package com.happylife.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happylife.dao.layer.LookingForDAOException;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.LookingFor;
import com.happylife.pojo.User;

/**
 * Servlet implementation class BioDataServlet 						*
 * It saves about_myself to the database							*
 * I am not able to use getAttribute in almost all cases			*
 * System.out.println("userId Attribute got from LoginServlet ...");*
 * render null 														*
 */
@WebServlet("/aboutme&lookingfor")
public class BioDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User sessionUsr = (User) session.getAttribute("sessionUser");	// Attribute sessionUser set in LoginServlet
		long id = (long)sessionUsr.getUserId();								// Attribute sessionUser set in LoginServlet
		
		try {
			String aboutme = RegistryDAO.getUserDAO().getAboutMe(id);
			String lookingfor = RegistryDAO.getLookingForDAO().getLookingForById(id).getLookingFor();
			session.removeAttribute("aboutMeInfo");
			session.removeAttribute("lookingForInfo");
			
			session.setAttribute("aboutMeInfo", aboutme);
			session.setAttribute("lookingForInfo", lookingfor);
		} catch (UserDAOException | LookingForDAOException e) {
			e.printStackTrace();
		}
		
		String loginArabicOrEnglish = (String) request.getSession().getAttribute("loginlang");
		System.out.println("Inside UpdateProfileServlet, loginlang is: " + loginArabicOrEnglish);
		if(loginArabicOrEnglish.equals("loginA")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/aboutmea.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/aboutme.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User sessionUsr = (User) session.getAttribute("sessionUser");	// Attribute sessionUser set in LoginServlet
		LookingFor lookingFor = (LookingFor) session.getAttribute("sessionLookingFor");	// Attribute sessionLookingFor set in LoginServlet
		String aboutme = request.getParameter("AboutMe");
		String langSpoken = request.getParameter("language");
		String profilePostedBy = request.getParameter("pcreatedby");
		String residencyStatus = request.getParameter("residencystatus");
		String ethnic = request.getParameter("ethnic");
		String rhistory = request.getParameter("rhistory");
		String pray = request.getParameter("pray");
		String sect = request.getParameter("sect");
		String mstatus = request.getParameter("mstatus");
		String havekids = request.getParameter("havekids");
		String liketohavekids = request.getParameter("liketohavekids");
		String bodytype = request.getParameter("bodytype");
		String haircolor = request.getParameter("haircolor");
		String hijaborbeard = request.getParameter("hijaborbeard");
		String height = request.getParameter("height");
		String languages = request.getParameter("language");
		String profession = request.getParameter("profession");
		String hqual = request.getParameter("hqual");
		
		String lookingfor = request.getParameter("LookingFor");
		String agefrom = request.getParameter("agefrom");
		String ageto = request.getParameter("ageto");
		String candidcountry = request.getParameter("candidcountry");
		String candidrs = request.getParameter("candidrs");
		String candidrelocate = request.getParameter("candidrelocate");
		String candidethnic = request.getParameter("candidethnic");
		String candidrh = request.getParameter("candidrh");
		String candidlivewinlaws = request.getParameter("candidlivewinlaws");
		String candidpray = request.getParameter("candidpray");
		String candidsect = request.getParameter("candidsect");
		String candidmstatus = request.getParameter("candidmstatus");
		String candidhavekids = request.getParameter("candidhavekids");
		String candidpdisability = request.getParameter("candidpdisability");
		String candidliketohavekids = request.getParameter("candidliketohavekids");
		String candidbodytype = request.getParameter("candidbodytype");
		String candidhijaborbeard = request.getParameter("candidhijaborbeard");
		String candidheightf = request.getParameter("candidheightf");
		String candidheightto = request.getParameter("candidheightto");
		String candidprofession = request.getParameter("candidprofession");
		String candidhqual = request.getParameter("candidhqual");
		
		String aboutMeMessage = "";
		String lookingForMessage = "";
		
		try {
			String msg = RegistryDAO.getUserDAO().updateUser(sessionUsr.getUserId(), "AboutMe", aboutme, "language", langSpoken,
					"pcreatedby", profilePostedBy, "residencystatus", residencyStatus, "ethnic", ethnic, "rhistory", rhistory,
					"pray", pray, "sect", sect, "mstatus", mstatus, "havekids", havekids, "liketohavekids", liketohavekids, 
					"bodytype", bodytype, "haircolor", haircolor, "hijaborbeard", hijaborbeard, "height", height, 
					"language", languages, "profession", profession, "hqual", hqual);
			
			String msgLf = RegistryDAO.getLookingForDAO().updateLookingFor(sessionUsr.getUserId(), "LookingFor", lookingfor,
					"ageL", agefrom, "ageH", ageto, "lookingIn", candidcountry, "candidresidencystatus", candidrs, 
					"willingtorelocate", candidrelocate, "candidethnic", candidethnic, "candidrh", candidrh, 
					"candidlivewinlaws", candidlivewinlaws, "candidpray", candidpray, "candidsect", candidsect, 
					"candidmstatus", candidmstatus, "candidhavekids", candidhavekids, "candidpdisability", candidpdisability, 
					"candidliketohavekids", candidliketohavekids, "candidbodytype", candidbodytype,
					"candidhijaborbeard", candidhijaborbeard, "candidheightf", candidheightf, "candidheightto", candidheightto, 
					"candidprofession", candidprofession, "candidhqual", candidhqual);
			aboutMeMessage = RegistryDAO.getUserDAO().updateAboutMe(sessionUsr, aboutme);
			lookingForMessage = RegistryDAO.getUserDAO().updateLookingFor(sessionUsr, lookingfor);
			System.out.println("Looking For updated Successfully...");
			
		}catch(UserDAOException | LookingForDAOException e) {
			e.printStackTrace();
			System.out.println("About me Message in BioDataServlet is: " + aboutMeMessage);
			System.out.println("Looking for Message in BioDataServlet is: " + lookingForMessage);
		}
		
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
