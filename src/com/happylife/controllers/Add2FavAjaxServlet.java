package com.happylife.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class Add2FavAjaxServlet, this servlet is Ajax, it doesn't load any page, but just shows alert message
 * first I had to check whether sessionUser has already added the candidate to their favorite list by fetching the existing string of Ids
 * converting it to a list of Long then checking for the candid id does exist or not, lastly sending the appended list to database again
 */
@WebServlet("/add2fav")
public class Add2FavAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String query = request.getQueryString();
		if (request.getQueryString() != null) {
			User sessionUser = (User)request.getSession().getAttribute("sessionUser");
			System.out.println("Query String is: " + query);
			long candidId = Long.parseLong(query.substring(7));
			System.out.println("Candidate Id inside MyFavoriteServlet = " + candidId);
			
			try {
				User candidUser = RegistryDAO.getUserDAO().getUserByUserId(candidId);
				
				// This test is done here for not to add the profile one more time to myfavorite
				String fetched = RegistryDAO.getUserDAO().getMyFavorites(sessionUser.getUserId());
				DoMath doM = new DoMath();
				List<Long> myFavUIDs = doM.string2List(fetched);
				String foundInFav = "No";
				if(!myFavUIDs.contains(candidUser.getUserId())) {
					fetched = fetched + "," + candidUser.getUserId();
					String flag = RegistryDAO.getUserDAO().add2MyFavorites(sessionUser.getUserId(), fetched);
					System.out.println("status of add2MyFavourites is: " + flag);
					if(flag.equals("success")){
						System.out.println("User added to myFavorites Successfully...");
					}else {
						System.out.println("Please try again!!!");
					}
				}else 
					foundInFav = "Yes";
				
				request.setAttribute("foundInMyFavAjax",foundInFav);	//I need to see how to use it
				
			} catch (UserDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/myfavorites.jsp");
			rd.forward(request, response);
		}
	}
}
