package com.happylife.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.User;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/morelike")
public class MoreLikeCandidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User sessionUsr = (User) session.getAttribute("sessionUser");	// Attribute sessionUser set in LoginServlet
		ServletContext ctx = getServletContext();
		User candidUser = (User) ctx.getAttribute("candidate");
		try {
			List<User> list = RegistryDAO.getUserDAO().searchBy(candidUser, "likecandid", "true");
			request.setAttribute("moreLikeCandidList", list);
			for(User user: list){
				System.out.println(user.getUsername());
			}
			request.getRequestDispatcher("/WEB-INF/jsp/morelike.jsp").forward(request, response);
		}catch(UserDAOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
