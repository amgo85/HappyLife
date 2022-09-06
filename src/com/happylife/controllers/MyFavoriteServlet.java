package com.happylife.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happylife.DoMath;
import com.happylife.dao.layer.LookingForDAOException;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.LookingFor;
import com.happylife.pojo.User;

/**
 * Servlet implementation class MyFavoriteServlet
 */
@WebServlet("/fav")
public class MyFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * ServletContext ctx = getServletContext(); // didn't work User candid = (User)
		 * ctx.getAttribute("candidate"); // didn't work giving null
		 * System.out.println("Inside MyFavoriteServlet: Candidate Id is: " +
		 * candid.getUserId());
		 * I have to create constructor with the minimum requirement of user to reduce the space 
		 */
		User sessionUser = (User)request.getSession().getAttribute("sessionUser");
		try {
			String fetched = RegistryDAO.getUserDAO().getMyFavorites(sessionUser.getUserId());
			DoMath doM = new DoMath();
			List<Long> myFavUIDs = doM.string2List(fetched);
			List<User> myFavUsers = new ArrayList<User>();
			for (Long uid:myFavUIDs) {
				User u  = RegistryDAO.getUserDAO().getUserByUserId(uid);
				myFavUsers.add(u);
			}
			request.setAttribute("favoriteList", myFavUsers);
		} catch (UserDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/myfavorites.jsp");
		rd.forward(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
