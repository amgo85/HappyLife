package com.happylife.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserPhotoServlet
 * This servlet didn't work 
 * the b64 is not appearing in session.
 */
@WebServlet("/uphoto")
public class UserPhotoViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    
	public UserPhotoViewServlet() {
		super();
		try {
			init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String photo = (String) request.getSession().getAttribute("personalPhoto");
		//InputStream confIn = getClass().getResourceAsStream(photo);
		System.out.println("Photo passed from loginServlet is " + photo);
		try {
			BufferedImage bImage = ImageIO.read(new File("/WEB-INF/usrphotos/"+photo));
		    System.out.println("Photo " + photo);
		    System.out.println("Buffered Image" + bImage);
		    ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    ImageIO.write( bImage, "PNG", baos );
		    baos.flush();
		    byte[] imageInByteArray = baos.toByteArray();
		    baos.close();
		    String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
		    request.getSession().setAttribute("b64", b64);
			
		} catch (IOException e) { 
		    e.printStackTrace(); 
		}
		
	}

}
