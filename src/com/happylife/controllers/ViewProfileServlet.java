package com.happylife.controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happylife.DoMath;
import com.happylife.cronjob.CheckingNewMessagesJob;
import com.happylife.dao.implementation.ViewedDAOImpl;
import com.happylife.dao.layer.LookingForDAOException;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.layer.ViewedDAO;
import com.happylife.dao.layer.ViewedDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.LookingFor;
import com.happylife.pojo.Messages;
import com.happylife.pojo.User;
import com.happylife.pojo.Viewed;
/*
 * any data saved to viewed table, the male viewer is the userId1, female viewer is always userId2
 * the sender is userId1 in SendMessageServlet... 
 * */

@WebServlet("/candid")
public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getQueryString();			// Extracting the candidate Id then look for user in the searchList gotten from Search Servlet
		if (request.getQueryString() != null) {
			System.out.println("Query String is: " + query);
			long candidId = Long.parseLong(query.substring(1));
			System.out.println("Candiate Id = " + candidId);
			//List<User> list = (List<User>) request.getAttribute("searchList");	// I couldn't get it, it is null		// Attribute was on Search Controller
			//if(list==null) System.out.println("List is Null");
			HttpSession session = request.getSession();
			try {
				User sessionUser = (User) session.getAttribute("sessionUser");
				User candidUser = RegistryDAO.getUserDAO().getUserByUserId(candidId);
				LookingFor lFor = RegistryDAO.getLookingForDAO().getLookingForById(candidId);
				
				// checking inbox for new messages at fixed intervals..
				CheckingNewMessagesJob c = new CheckingNewMessagesJob();
				List<Messages> unReadList = c.checkInboxfor(sessionUser.getUserId());
				
				// saving notification to hl_users table, adding the ',' seperator is taken care of in updateNotifications()
				String notes = RegistryDAO.userDAO.updateNotifications(candidId, "candidId "+ sessionUser.getUserId()+ " viewed your profile");
				System.out.println("candidId '" + sessionUser.getUserId() + " viewed " + candidId + "' saving to database status: " + notes);
				String fetched = RegistryDAO.getUserDAO().getMyFavorites(sessionUser.getUserId());
				// to check whether or not candidUser is in myfavorite list or not
				String foundInFav = "No";
				
				DoMath doM = new DoMath();	//
				String htmlCode = "<h2>As-Salaamu Alaikum " + candidUser.getUsername()+ "<br/>" + sessionUser.getUsername() + " has viewed your profile</h2> <br/> <h3><b>click here to view their profile</b></h3>";
				doM.sendEmail(candidUser.getEmail(), "viewed", htmlCode);
				List<Long> myFavUIDs = doM.string2List(fetched);
				if(myFavUIDs.contains(candidUser.getUserId())) foundInFav = "Yes";
				//LookingFor candidlookingFor = RegistryDAO.getLookingForDAO().getLookingForById(candidUser.getUserId());
				String recordMsg = RegistryDAO.getViewedDAO().checkIfRecordExists(sessionUser.getUserId(), candidUser.getUserId());
				
				System.out.println("record message before if : " + recordMsg);
				if(recordMsg.equalsIgnoreCase("Not Found")) {
					Viewed viewed = new Viewed();
					viewed.setHistoryContent(sessionUser.getUsername() + " viewed " + candidUser.getUsername() + "'s profile, ");
					if(sessionUser.getGender().equals("M")) {
						viewed.setUid1(sessionUser.getUserId());
						viewed.setUid2(candidUser.getUserId());
						viewed.setUser1vieweduser2(true);
						viewed.setUser2vieweduser1(false);
					}else {
						viewed.setUid2(sessionUser.getUserId());
						viewed.setUid1(candidUser.getUserId());
						viewed.setUser2vieweduser1(true);
						viewed.setUser1vieweduser2(false);
					}
					viewed.setUser1inviteduser2(false);
					viewed.setUser2inviteduser1(false);
					String viewedInsert = RegistryDAO.getViewedDAO().insertViewed(viewed);
					System.out.println("Inviewed inserted msg: " + viewedInsert);
				}else {
					System.out.println("Inside ViewProfileServlet else: recordMsg is "+ recordMsg);
					// I need to check if I can do it in another way, I should append directly to the database
					recordMsg = recordMsg + sessionUser.getUsername() + " viewed " + candidUser.getUsername() + "'s profile" + ", ";
					System.out.println("Inside ViewProfileServlet else after concat: recordMsg is "+ recordMsg);
					String viewedUpdated = "";
					if(sessionUser.getGender().equals("M")) 
						viewedUpdated = RegistryDAO.getViewedDAO().updateViewed(sessionUser.getUserId(), candidUser.getUserId(), 
																					"u1vu2", "true", "record", recordMsg);
					else
						viewedUpdated = RegistryDAO.getViewedDAO().updateViewed(sessionUser.getUserId(), candidUser.getUserId(), 
																					"u2vu1", "true", "record", recordMsg);
					System.out.println("viewed updated msg: " + viewedUpdated);
				}
				
				System.out.println("Candidate User is: " + candidUser.getEmail());
				request.setAttribute("candidate", candidUser);
				request.setAttribute("candidLookingfor", lFor);
				//request.setAttribute("CandidateLookingfor", candidlookingFor);
				String lastLogin = doM.getLastLogin(candidUser.getLastLogin());
				request.setAttribute("candidLastLogin", lastLogin);
				System.out.println("Candidate User: " + candidUser.getUsername() + " is in myFavorites? " + foundInFav);
				request.setAttribute("foundInMyFavList",foundInFav);
				
				ServletContext ctx = getServletContext();
				ctx.setAttribute("candidate", candidUser);
			} catch (UserDAOException | LookingForDAOException | ViewedDAOException | MessagingException e) {
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/viewcandid.jsp");
		rd.forward(request, response);
	}
	
}
