package com.happylife.filters;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
/*
 * @WebFilter( dispatcherTypes = { DispatcherType.REQUEST,
 * DispatcherType.FORWARD, DispatcherType.ERROR } , urlPatterns = {
 * "/AuthFilter" }, servletNames = { "MyProfileServlet", "BioDataServlet",
 * "SearchController", "SendMessageServlet", "UpdateProfileServlet",
 * "ViewInboxServlet", "ViewProfileServlet", "UploadPhotoServlet" })
 */

public class AuthFilter implements Filter {
	
	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("In Filter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		StringBuffer uriBuf = req.getRequestURL();
		String uri = uriBuf.toString();
		System.out.println("uri="+uri);
		System.out.println(session ==null?"session is  null":"session is not null");
		System.out.println("Hello Login Authentication Filter");
		/*
		 * if(session == null && (!(uri.indexOf("/adminlogin")!=-1 ))) {
		 * System.out.println("hello inside the if 1");
		 * res.sendRedirect("http://localhost:8080/HappyLife/adminlogin"); return; }
		 */
		if(session == null && (!(uri.indexOf("/login.html")!=-1 ||uri.indexOf("/login")!=-1 || uri.indexOf("/signup.jsp")!=-1 || uri.indexOf("/adminlogin.jsp")!=-1 || uri.indexOf("/adminsignup.jsp")!=-1 || uri.indexOf("/reset")!=-1 || uri.indexOf("/js")!=-1 || uri.indexOf("/css")!=-1|| uri.indexOf("/fonts")!=-1 || uri.indexOf("/images")!=-1  || uri.indexOf("/color-switcher")!=-1))) {
			System.out.println("hello inside the if");
			res.sendRedirect("http://localhost:8080/HappyLife/login");
			return;
		}
		System.out.println("Hello Login Authentication Filter");
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("inside Filter init");
	}
}
