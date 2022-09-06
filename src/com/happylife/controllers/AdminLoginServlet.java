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

import com.happylife.dao.layer.AdminDAOException;
import com.happylife.dao.layer.MessageDAOException;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.Admin;
import com.happylife.pojo.Messages;
import com.happylife.pojo.User;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet(urlPatterns = "/adminlogin", loadOnStartup = 0)
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin_login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String loginArabicOrEnglish = request.getParameter("login");
		System.out.println("loginArabicOrEnglish = " + loginArabicOrEnglish);
		System.out.println("Username and pasword are : "+email +"  "+ password);
		
		try {
			Admin adminFetched = RegistryDAO.getAdminDAO().doLogin(email, password);
			if(adminFetched != null){
				System.out.println("Admin id: "+adminFetched.getAdminId());
				
				List<Messages> toApproveList = RegistryDAO.getMessageDAO().getAllMsgsToApprove();
				
				List<User> usersList = new ArrayList<User>();
				for(Messages m: toApproveList){
					User u = RegistryDAO.getUserDAO().getUserByUserId(m.getSenderId());
					System.out.println("Message " + m.getMessageId() + " is " + m.getMsgContent());
					usersList.add(u);
				}
				
				session.setAttribute("sessionAdmin", adminFetched);
				if(loginArabicOrEnglish.equals("loginA")) session.setAttribute("loginArabicOrEnglish", "loginA");
				else session.setAttribute("loginArabicOrEnglish", "login");
				session.setAttribute("username", adminFetched.getUsername());
				session.setAttribute("sessionAdminGender", adminFetched.getGender());
				
				/*
				 * To make these variables visible in the AdminProfileServlet, I must do this
				 * 
				 * */
				request.getServletContext().setAttribute("toApproveList", toApproveList);
				request.getServletContext().setAttribute("usersList", usersList);
				
				request.setAttribute("toApproveList", toApproveList);
				request.setAttribute("usersList", usersList);
				
				if(loginArabicOrEnglish.equals("loginA")) {
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin_profile_arabic.jsp");
					rd.forward(request, response);
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin_profile.jsp");
					rd.forward(request, response);
				}
			}else {
				request.setAttribute("error_msg", "please try again");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin_login.jsp");
				rd.forward(request,response);
			}
		} catch (AdminDAOException | MessageDAOException | UserDAOException e) {
			e.printStackTrace();
		}
	}
}