package com.happylife.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happylife.pojo.User;

@WebServlet("/myprofile")
public class MyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String profileArabicOrEnglish = req.getParameter("profile");
		System.out.println("profileArabicOrEnglish = " + profileArabicOrEnglish);
		HttpSession session = req.getSession();
		User sessionUsr = (User) session.getAttribute("sessionUser");	// Attribute sessionUser set in LoginServlet
		String personalPhoto = sessionUsr.getImage();
		ServletContext ctx = getServletContext();
		//String path = req.getSession().getServletContext().getRealPath("/") + "//WEB-INF//images//usrphotos//";
		ctx.setInitParameter("photo", "WEB-INF/usrphotos/" + personalPhoto);
		System.out.println("Personal photo path is "+ ctx.getInitParameter("photo"));
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String loginArabicOrEnglish = (String) req.getSession().getAttribute("loginlang");
		System.out.println("Inside MyProfileServlet, loginlang is: " + loginArabicOrEnglish);
		if(loginArabicOrEnglish.equals("loginA")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/myprofilea.jsp");
			rd.forward(req, res);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/myprofile.jsp");
			rd.forward(req, res);
		}
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException{
		HttpSession session = req.getSession();
		User sessionUsr = (User) session.getAttribute("sessionUser");	// Attribute sessionUser set in LoginServlet
		
	}
	

}
