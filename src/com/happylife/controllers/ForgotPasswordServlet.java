package com.happylife.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happylife.dao.layer.ResetDAOException;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.User;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/reset")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/forgot.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("remail");
		try {
			User u = RegistryDAO.getUserDAO().getUserByEmail(email);
			String link = RegistryDAO.getResetDAO().addResetLink(email);
			System.out.println("Link generated inside ForgotPasswordServlet is: " +link);
			request.setAttribute("resetLink",link);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/forget_pass_success.jsp");
			rd.forward(request,response);
		} catch (UserDAOException | ResetDAOException e) {
			System.out.println("inside ForgotPasswordServlet catch block");
			e.printStackTrace();
		}
	}
}
