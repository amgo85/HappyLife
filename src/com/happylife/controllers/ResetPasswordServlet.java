package com.happylife.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happylife.dao.implementation.ResetDAOImpl;
import com.happylife.dao.layer.ResetDAO;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.User;

/**
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet("/resetlink")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// before showing the page I am making some validation..
		String query = request.getQueryString();			// Extracting the token to verify
		if (request.getQueryString() != null) {
			System.out.println("Query String is: " + query);
			String token = query.substring(1);
			String emailtoReset = request.getParameter("email");			// is recieved from forgot_password_success from Eamil
			try {
				String emailFound = RegistryDAO.getResetDAO().validateToken(token);
				request.setAttribute("emailFound",emailFound);
			} catch(Exception e){
				System.out.println("inside catch block");
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/reset_pass_form.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String newPass = request.getParameter("newpasswd");
			String confNewPass = request.getParameter("confirmnewpasswd");
			System.out.println("new Pass is: " +newPass);
			System.out.println("Confirmed new Pass is: " +confNewPass);
			
			String emailtoReset = request.getParameter("email");
			User u = RegistryDAO.getUserDAO().getUserByEmail(emailtoReset);
			String msg = RegistryDAO.getUserDAO().updateUser(u.getUserId(), "password");
			
		} catch(Exception e){
			System.out.println("inside catch block");
			e.printStackTrace();
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pass_updated.jsp");
			rd.forward(request, response);						// I forgot this one....
		}
	}

}
