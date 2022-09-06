package com.happylife.controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happylife.dao.layer.AdminDAOException;
import com.happylife.dao.layer.ResetDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.Admin;


/**
 * Servlet implementation class AdminSignUpServlet
 */
@WebServlet("/adminsignup")
public class AdminSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin_signup.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String signupStatus = "";
		String message = "";
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String gender = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String dobStr = request.getParameter("dob");
		Date dob = Date.valueOf(dobStr);
		
		Admin admin = new Admin();
		admin.setFname(firstName);
		admin.setLname(lastName);
		admin.setEmail(email);
		admin.setUsername(username);
		admin.setPassword(password);
		admin.setGender(gender);
		admin.setPhone(phone);
		admin.setDob(dob);
		if(password.equals(repassword)){
			try {
				signupStatus = RegistryDAO.getAdminDAO().doSignUp(admin);
				System.out.println(" this is status from Admin doSignUp: " + signupStatus);
				
				String token = java.util.UUID.randomUUID().toString();
				RegistryDAO.getResetDAO().activateAccount(email,token);
				
			} catch (AdminDAOException | ResetDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			message = "Password does not match..please try again";
			request.setAttribute("errorMsg", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin_signup.jsp");
			rd.forward(request,response);
		}
		if(signupStatus.equals("Admin Signup Successfully..."))	request.getRequestDispatcher("/WEB-INF/jsp/admin_login.jsp").forward(request,response);
		else {
			request.setAttribute("errorMsg", message);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
	}

}
