package com.happylife.controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;

import com.happylife.DoMath;
import com.happylife.dao.layer.LookingForDAOException;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.layer.ViewedDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.LookingFor;
import com.happylife.pojo.User;
import com.happylife.pojo.Viewed;

/*
 * The viewedMe to be shown in the myprofile page
 * but three only will be shown, rest shall be displayed in a different page 
 * 
 * */

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		rd.forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		//BindingResult br = null;
		//Model md = null;
		HttpSession session = req.getSession();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String loginArabicOrEnglish = req.getParameter("login");
		System.out.println("loginArabicOrEnglish = " + loginArabicOrEnglish);
		System.out.println("Username and pasword are : "+email +"  "+ password);
		//if(br.getAllErrors().size() > 0){
			//System.out.println("Server side validation takes place....");	
		//}else{

			try {
				User userFetched = RegistryDAO.getUserDAO().doLogin(email, password);
				
				//User userFetched = RegistryDAO.getUserDAO().doHibernateLogin(email, password);
				
				if(userFetched != null){
					DoMath doM = new DoMath();
					int age = doM.getAge(userFetched.getDob());
					String msg = RegistryDAO.getUserDAO().updateUser(userFetched.getUserId(), "Age", Integer.toString(age));
					LookingFor lookingFor = RegistryDAO.getLookingForDAO().getLookingForById(userFetched.getUserId());
					List<Viewed> viewedMe = RegistryDAO.getViewedDAO().getViewedForUser(userFetched.getUserId(), userFetched.getGender());
					System.out.println("LoginServlet, people viewed me");
					
					if(viewedMe!= null) {
						int count = 0;
						List<User> viewedList = new ArrayList<User>();
						for(Viewed v:viewedMe) {
							count++;
							if(count<=3) {
								User userViewedMe = new User();
								System.out.println(v.getHistoryContent());
								if(userFetched.getGender().equals("M")) userViewedMe = RegistryDAO.getUserDAO().getUserByUserId(v.getUid2());
								else userViewedMe = RegistryDAO.getUserDAO().getUserByUserId(v.getUid1());
								viewedList.add(userViewedMe);		// I need to add only three to the myprofile page
							}
							
						}
						session.setAttribute("viewedMeList", viewedList);	// To be avoided, not to overload session
						//session.setAttribute("lastViewedMe", viewedList.get(viewedList.size()-1));		// This also creates some problems if none viewed user profile
						//List<User> subViewedList = viewedList.subList(viewedList.size()-3, viewedList.size());		// This approach has a problem because not everytime there are at least 3 people viewed the profile 
					}
					
					System.out.println(lookingFor.getLookingFor());
					
					session.setAttribute("sessionUser", userFetched);
					session.setAttribute("sessionLookingFor", lookingFor);
					session.setAttribute("userId", userFetched.getUserId());
					session.setAttribute("username", userFetched.getUsername());
					session.setAttribute("gender",  userFetched.getGender());
					
					session.setAttribute("personalPhoto", userFetched.getImage());
					session.setAttribute("publicPhoto", userFetched.getPublicPhoto()+".JPG");
					session.setAttribute("aboutMeInfo", userFetched.getAboutMe());
					session.setAttribute("lookingForInfo", userFetched.getMyFavorites());
					session.setAttribute("myAge", doM.getAge(userFetched.getDob()));
					System.out.println("Fetched Personal photo name is "+ userFetched.getImage());
					System.out.println("Fetched Public photo name is "+ userFetched.getPublicPhoto());
					session.setAttribute("photopath", "D:/tutorials/Github/HappyLife/WebContent/WEB-INF/usrphotos/"+userFetched.getImage());
					
					session.setAttribute("loginlang", loginArabicOrEnglish);
					// this context never worked for me
					ServletContext ctx = getServletContext();
					//ctx.setInitParameter("loginlang",loginArabicOrEnglish);
					
					System.out.println("Inside LoginServlet, loginlang is: " + loginArabicOrEnglish);
					if(loginArabicOrEnglish.equals("loginA")) {
						RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/myprofilea.jsp");
						rd.forward(req, res);
					}else {
						RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/myprofile.jsp");
						rd.forward(req, res);
					}
					//res.sendRedirect("myprofile");
				}else{
					//md.addAttribute("error_msg", "please try again");
					req.setAttribute("error_msg", "please try again");
					RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
					rd.forward(req,res);
				}
			} catch (UserDAOException | LookingForDAOException | ViewedDAOException e) {
				e.printStackTrace();
				res.sendRedirect("login.html");
			}
			
		//}
	}
}
