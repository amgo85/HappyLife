package com.happylife.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("sessionUser");
		session.removeAttribute("sessionLookingFor");
		session.removeAttribute("userId");
		session.removeAttribute("username");
		session.removeAttribute("gender");
		session.removeAttribute("aboutMeInfo");
		session.removeAttribute("lookingForInfo");		
		session.removeAttribute("personalPhoto");
		session.removeAttribute("publicPhoto");
		session.removeAttribute("photopath");
		
		session.invalidate();
		System.out.println("Logout has been clicked");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
