package com.happylife.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happylife.pojo.User;

/**
 * Servlet implementation class PersonalInfoServlet
 */
@WebServlet("/pinfo")
public class PersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String loginArabicOrEnglish = (String) request.getSession().getAttribute("loginlang");
		System.out.println("Inside UpdateProfileServlet, loginlang is: " + loginArabicOrEnglish);
		if(loginArabicOrEnglish.equals("loginA")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pinfoa.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pinfo.jsp");
			rd.forward(request, response);
		}
	}

}
