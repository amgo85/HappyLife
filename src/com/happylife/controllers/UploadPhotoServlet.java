package com.happylife.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.happylife.dao.registry.RegistryDAO;

/**
 * Servlet implementation class UploadPhotoServlet
 * String path = request.getSession().getServletContext().getRealPath("/") + "//WEB-INF//usrphotos//";
 * the above line of code saved the photo under this path
 * (F:\Github\.metadata\/plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\HappyLife\...)
 */
@WebServlet("/uploadphoto")
public class UploadPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { RequestDispatcher rd =
	 * request.getRequestDispatcher("/WEB-INF/jsp/uploaded.jsp");
	 * rd.forward(request, response); //response.sendRedirect("pinfo");
	 * //response.getWriter().append("Served at: ").append(request.getContextPath())
	 * ; }
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		try {
			List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			String path = "F:\\Github\\HappyLife\\WebContent\\WEB-INF\\usrphotos\\";
			System.out.println("Path = " + path);
			long userId = (Long)request.getSession().getAttribute("userId");		// was set in LoginServlet
			System.out.println("UserId in UploadPhotoServlet is " + userId);
			System.out.println("Photo Name in UploadPhotoServlet is " + data.get(0).getName());
			
			for(FileItem item: data) {
				File file = new File(path + item.getName());
				if (!file.exists())
					item.write(file);
				else System.out.println("File exist");
			}
			
			//msg = RegistryDAO.getUserDAO().updateUserPhoto(userId, data.get(0).getName());
			msg = RegistryDAO.getUserDAO().updateUser(userId, "personalphoto", data.get(0).getName());
			System.out.println("File uploaded");
		} catch (Exception e) {
			System.out.println("result got fro updating user is " + msg);
			e.printStackTrace();
		}
		//doGet(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pinfo.jsp");
		rd.forward(request, response);
	}

}
