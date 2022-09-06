package com.happylife.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happylife.dao.layer.MessageApprovalDAOException;
import com.happylife.dao.layer.MessageDAOException;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.Admin;
import com.happylife.pojo.Messages;
import com.happylife.pojo.User;


/**
 * Servlet implementation class MessageApproveServlet
 */
@WebServlet(urlPatterns = "/msgtoapprove")
public class MessageApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Admin sessionAdmin = (Admin) session.getAttribute("sessionAdmin");	// Attribute AdminUser set in AdminLoginServlet
		
		String query = request.getQueryString();
		System.out.println("Query String in MessageApproveServlet doGet is: " + query);
		if (request.getQueryString() != null && sessionAdmin != null) {
			long msgId = Long.parseLong(query.substring(3));
			System.out.println("Message Id in MessageApproveServlet doGet = " + msgId);
			try {
				Messages m = RegistryDAO.getMessageDAO().getChat(msgId);
				request.setAttribute("chat", m);
				request.setAttribute("msgId", m.getMessageId());
				
				request.getServletContext().setAttribute("chat", m);
				request.getServletContext().setAttribute("msgId", m.getMessageId());
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/msg_approval.jsp");
				rd.forward(request, response);
				
			} catch (MessageDAOException e) {
				e.printStackTrace();
			}
		}else System.out.println("query in MessageApproveServlet is Null");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Admin sessionAdmin = (Admin) session.getAttribute("sessionAdmin");	// Attribute AdminUser set in AdminLoginServlet
		if (sessionAdmin != null) {
			String appr = request.getParameter("approve");
			System.out.println("Approve in MessageApproveServlet doPost is: " + appr);
			if (request.getQueryString() != null) {
				String query = request.getQueryString();
				String approveMessageStatus = null;
				String updateMessageApprovedStatus = null;
				System.out.println("Query String in MessageApproveServlet doPost is: " + query);
				long msgId = Long.parseLong(query.substring(3));	//i.e., id=12
				System.out.println("Parsed message id in MessageApproveServlet doPost is: " + msgId);
				try {
					if(appr.equalsIgnoreCase("Yes")) {	
						approveMessageStatus = RegistryDAO.getMessageApprovalDAO().approveMessage(msgId, sessionAdmin.getAdminId(), true);
						updateMessageApprovedStatus = RegistryDAO.getMessageDAO().updateMessageApprovedStatus(msgId, true);
					}else {
						approveMessageStatus = RegistryDAO.getMessageApprovalDAO().approveMessage(msgId, sessionAdmin.getAdminId(), false);
						updateMessageApprovedStatus = RegistryDAO.getMessageDAO().updateMessageApprovedStatus(msgId, false);
					}
					
					List<Messages> toApproveList = RegistryDAO.getMessageDAO().getAllMsgsToApprove();
					List<User> usersList = new ArrayList<User>();
					for(Messages m: toApproveList){
						User u = RegistryDAO.getUserDAO().getUserByUserId(m.getSenderId());
						System.out.println("Message " + m.getMessageId() + " is " + m.getMsgContent());
						usersList.add(u);
					}
					request.getServletContext().setAttribute("toApproveList", toApproveList);
					request.getServletContext().setAttribute("usersList", usersList);
					
				}catch (MessageApprovalDAOException | MessageDAOException | UserDAOException e) {
					System.out.println("Inside MessageApproveServlet doPost(), approveMessageStatus is " + approveMessageStatus);
					System.out.println("Inside MessageApproveServlet doPost(), updateMessageApprovedStatus is " + updateMessageApprovedStatus);
					e.printStackTrace();
				}
			}else {
				System.out.println("Query inside doPost is null");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin_profile.jsp");
			rd.forward(request,response);
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin_login.jsp");
			rd.forward(request,response);
		}
	}
	
	
}