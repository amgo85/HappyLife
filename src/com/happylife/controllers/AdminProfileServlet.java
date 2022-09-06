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

import com.happylife.dao.layer.MessageApprovalDAOException;
import com.happylife.dao.layer.MessageDAOException;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.Admin;
import com.happylife.pojo.Messages;
import com.happylife.pojo.User;

/**
 * Servlet implementation class AdminProfileServlet
 */
@WebServlet(urlPatterns = {"/admin_profile", "/admin_approved"}, loadOnStartup = 1)
public class AdminProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin adminFetched = (Admin) request.getSession().getAttribute("sessionAdmin");		// set in AdminLoginServlet
		/*
		 * List<Messages> toApproveList = (List<Messages>)
		 * request.getServletContext().getAttribute("toApproveList"); List<User>
		 * usersList = (List<User>)
		 * request.getServletContext().getAttribute("usersList"); for(Messages m:
		 * toApproveList){ System.out.println("Inside AdminProfileServlet() Message " +
		 * m.getMessageId() + " is " + m.getMsgContent()); }
		 * request.setAttribute("toApproveList", toApproveList);
		 * request.setAttribute("usersList", usersList);
		 */
		//ApprovedMessages
		String url = request.getRequestURL().toString();
		boolean hasAdminClickedToSeeHisApprovedList = false;
		if(url != null && adminFetched != null) {
			System.out.println("Query String in AdminProfileServlet is: " + url);
			hasAdminClickedToSeeHisApprovedList = url.indexOf("admin_approved")!= -1?true:false;
			System.out.println("does Query contain admin_approved? " + hasAdminClickedToSeeHisApprovedList);
			
			try {
				System.out.println("Session Admin inside AdminProfileServlet id = " + adminFetched.getAdminId());
				List<Long> approvedMsgsListIds = RegistryDAO.getMessageApprovalDAO().getAllApproved(adminFetched.getAdminId());
				List<Messages> approvedMessagesList = new ArrayList<Messages>();
				List<User> approvedMessageSendersList = new ArrayList<User>();
				for(Long mid: approvedMsgsListIds){
					Messages m = RegistryDAO.getMessageDAO().getChat(mid);
					approvedMessagesList.add(m);
					User u = RegistryDAO.getUserDAO().getUserByUserId(m.getSenderId());
					System.out.println("Message " + m.getMessageId() + " is " + m.getMsgContent());
					approvedMessageSendersList.add(u);
				}
				
				List<Messages> toApproveList = RegistryDAO.getMessageDAO().getAllMsgsToApprove();
				
				List<User> usersList = new ArrayList<User>();
				for(Messages m: toApproveList){
					User u = RegistryDAO.getUserDAO().getUserByUserId(m.getSenderId());
					System.out.println("Message " + m.getMessageId() + " is " + m.getMsgContent());
					usersList.add(u);
				}
				
				// I have to update them since login has happened
				request.getServletContext().removeAttribute("toApproveList");
				request.getServletContext().removeAttribute("usersList");
				request.getServletContext().setAttribute("toApproveList", toApproveList);
				request.getServletContext().setAttribute("usersList", usersList);
				
				request.setAttribute("approvedMessagesList", approvedMessagesList);
				request.setAttribute("approvedMessageSendersList", approvedMessageSendersList);
			} catch (MessageApprovalDAOException | MessageDAOException | UserDAOException e) {
				System.out.println("MessageApprovalDAOException or UsrDAOException or MessageDAOException");
				e.printStackTrace();
			}
		}else {
			System.out.println("Query String in AdminProfileServlet is null or admin is null");
		}
		
		// This part is not needed I feel. it should be removed, allApproved must be linked to an Admin except if i want admin of admins
		/*
		 * try { List<Long> approvedMsgsListIds =
		 * RegistryDAO.getMessageApprovalDAO().getAllApproved(); List<Messages>
		 * approvedMessagesList = new ArrayList<Messages>(); List<User>
		 * approvedMessageSendersList = new ArrayList<User>(); for(Long mid:
		 * approvedMsgsListIds){ Messages m = RegistryDAO.getMessageDAO().getChat(mid);
		 * approvedMessagesList.add(m); User u =
		 * RegistryDAO.getUserDAO().getUserByUserId(m.getSenderId());
		 * System.out.println("Message " + m.getMessageId() + " is " +
		 * m.getMsgContent()); approvedMessageSendersList.add(u); }
		 * request.setAttribute("approvedMessagesList", approvedMessagesList);
		 * request.setAttribute("approvedMessageSendersList",
		 * approvedMessageSendersList); }catch(Exception e) { System.out.
		 * println("MessageApprovalDAOException or UsrDAOException or MessageDAOException"
		 * ); }
		 */
		
		// This part is not needed I feel. it should be removed, allApproved must be linked to an Admin
		
		String loginArabicOrEnglish = (String) request.getSession().getAttribute("loginArabicOrEnglish");	// set in AdminLoginServlet
		if(adminFetched != null) {
			if(loginArabicOrEnglish.equals("loginA")) {
				//response.sendRedirect("http://localhost:8080/HappyLife/admin_profile_arabic");
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin_profile_arabic.jsp");
				rd.forward(request, response);
			}else {
				//response.sendRedirect("http://localhost:8080/HappyLife/admin_profile");
				if(hasAdminClickedToSeeHisApprovedList) 
					request.getRequestDispatcher("/WEB-INF/jsp/admin_approved_list.jsp").forward(request, response);
				else{ 
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin_profile.jsp");
					rd.forward(request, response);
				}
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin_login.jsp");
			rd.forward(request, response);
		}
	}

}
