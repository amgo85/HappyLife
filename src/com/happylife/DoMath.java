package com.happylife;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.happylife.pojo.LookingFor;
import com.happylife.pojo.User;

public class DoMath {

	public DoMath() {
		
	}
	
	public int getAge(Date dobSql) {
		
		long millis = System.currentTimeMillis();  
		Date now = new Date(millis);
		System.out.println("current date in DoMath is " + now);
		System.out.println("Date of Birth in DoMath is " + dobSql);
		
		Calendar dobCal = Calendar.getInstance();
		dobCal.setTime(dobSql);
		int monthOfBirth = dobCal.get(Calendar.MONTH);
		int dayOfBirth = dobCal.get(Calendar.DAY_OF_MONTH);
		int yearOfBirth = dobCal.get(Calendar.YEAR);
		
		Calendar nowCal = Calendar.getInstance();
		int month = nowCal.get(Calendar.MONTH);
		int day = nowCal.get(Calendar.DAY_OF_MONTH);
		int year = nowCal.get(Calendar.YEAR);
		
		System.out.println("Month of now in DoMath is " + month);
		System.out.println("Month of Birth in DoMath is " + monthOfBirth);
		int yearDiff = year - yearOfBirth;
		int monthDiff = month - monthOfBirth;
		int dayDiff = day - dayOfBirth;
		if(dayDiff >= 28)	monthDiff++;
		else if (dayDiff <= -28) monthDiff--;
		
		if(monthDiff >= 11)	yearDiff++;
		else if (monthDiff <= -11) yearDiff--;
		return yearDiff;	
	}
	
	public String getLastLogin(Timestamp ts){
		//Date date = Date.valueOf(ts.toLocalDateTime().toLocalDate());
		Calendar cal = Calendar.getInstance();
		cal.setTime(ts);
		int llYear = cal.get(Calendar.YEAR);
		int llMonth = cal.get(Calendar.MONTH);
		int llDay = cal.get(Calendar.DAY_OF_MONTH);
		int llHour = cal.get(Calendar.HOUR_OF_DAY);
		int llMinute = cal.get(Calendar.MINUTE);
		
		Calendar nowCal = Calendar.getInstance();
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		nowCal.setTime(stamp);
		System.out.println("Timestamp now " + stamp);
		
		int year = nowCal.get(Calendar.YEAR);
		int month = nowCal.get(Calendar.MONTH);
		int day = nowCal.get(Calendar.DAY_OF_MONTH);
		int hour = nowCal.get(Calendar.HOUR_OF_DAY);
		int minute = nowCal.get(Calendar.MINUTE);
		
		int yearDiff = year - llYear;
		int monthDiff = month - llMonth;
		int dayDiff = day - llDay;
		int hourDiff = hour - llHour;
		int minuteDiff = minute - llMinute;
		if(yearDiff > 0)		return yearDiff>1?   yearDiff + " years": yearDiff + " year";
		else if(monthDiff > 0)	return monthDiff>1?  monthDiff + " months": monthDiff + " month";
		else if(dayDiff > 0)	return dayDiff>1?    dayDiff + " days": dayDiff + " day";
		else if(hourDiff > 0) 	return hourDiff>1?   hourDiff + " hours": hourDiff + " hour";
		else if(minuteDiff > 5) return minuteDiff + " minutes";
		else return "Online";
	}
	
	public List<Long> string2List(String ids){
		List<Long> UIDsList = new ArrayList<Long>();
		if(!ids.equals("")) {
			String str[] = ids.split(",");
			List<String> al = new ArrayList<String>();
			al = Arrays.asList(str);
			for(String s: al){
				UIDsList.add(Long.parseLong(s));
				System.out.println("my favorite id " + s);
			}
		}
		return UIDsList;
	}
	
	public String constructQuery(User user, String query) {
		String column = "lookingin";
		boolean flag = false;
		switch (column) {
		case "lookingin":
			if(user.getLookingIn()!= null) {
				flag = true ;
				query = query + "(" +column + "='" + user.getLookingIn() + "' or " +column+ "='dontmind')";
			}
			column = "ethnicorigin";
		case "ethnicorigin":
			if(user.getEthnicOrigin()!= null && !user.getEthnicOrigin().equals("preferN")) {
				if(flag) query = query + " and "; else flag = true;
				query = query + "(" +column + "='" + user.getEthnicOrigin() + "' or " +column+ "='dontmind')";
			}
			column = "bodytype";
		case "bodytype":
			if(user.getBodyType()!= null && !user.getBodyType().equals("preferN")) {
				if(flag) query = query + " and "; else flag = true;
				query = query + "(" +column + "='" + user.getBodyType() + "' or " +column+ "='dontmind')";
			}
			column = "hijab_beard";
		case "hijab_beard":
			if(user.getHijabBeard()!= null && !user.getHijabBeard().equals("preferN")) {
				if(flag) query = query + " and "; else flag = true;
				query = query + "(" +column + "='" + user.getHijabBeard() + "' or " +column+ "='dontmind')";
			}
			column = "pray";
		case "pray":
			if(user.getPray()!= null) {
				if(flag) query = query + " and "; else flag = true;
				query = query + "(" +column + ">='" + user.getPray() + "' or " +column+ "='dontmind')";
			}
			column = "sect";
		case "sect":
			if(user.getSect()!= null && !user.getSect().equals("preferN")) {
				if(flag) query = query + " and "; else flag = true;
				query = query + "(" +column + "='" + user.getSect() + "' or " +column+ "='dontmind')";
			}
			column = "maritalstatus";
		case "maritalstatus":
			if(user.getMaritalStatus()!= null && !user.getMaritalStatus().equals("preferN")) {
				if(flag) query = query + " and "; else flag = true;
				query = query + "(" +column + "='" + user.getMaritalStatus() + "' or " +column+ "='dontmind')";
			}
			column = "profession";
		case "profession":
			if(user.getProfession()!= null) {
				if(flag) query = query + " and "; else flag = true;
				query = query + "(" +column + "='" + user.getProfession() + "' or " +column+ "='dontmind'" + " or " +column+ "='Other')";
			}
			column = "AgeRange";
			/*
			 * case "AgeRange": for(LookingFor lf:agerange) { query = query + " and "; query
			 * = query + "'" +user.getAge(user.getDob())+ "'" + " between AgeL and AgeH "; }
			 * column = "HeightRange"; case "HeightRange": for(LookingFor lf:heightrange) {
			 * query = query + " and "; query = query + "'" +user.getHeight()+ "'" +
			 * " between HeightL and HeightH "; }
			 */
		}
		
		return query;
	}
	public String constructLookingForQuery(User user, String [][] agerange, String [][] heightrange) {
		String query = "select userId from looking_for where ";
		String column = "lookingin";
		switch (column) {
		case "lookingin":
			if(user.getLookingIn()!= null) {
				query = query + column + "='" + user.getLookingIn() + "' or " +column+ "='dontmind'";
			}
			column = "ethnicorigin";
		case "ethnicorigin":
			if(user.getEthnicOrigin()!= null && !user.getEthnicOrigin().equals("preferN")) {
				query = query + " and ";
				query = query + column + "='" + user.getEthnicOrigin() + "' or " +column+ "='dontmind'";
			}
			column = "bodytype";
		case "bodytype":
			if(user.getBodyType()!= null &&!user.getBodyType().equals("preferN")) {
				query = query + " and ";
				query = query + column + "='" + user.getBodyType() + "' or " +column+ "='dontmind'";
			}
			column = "hijab_beard";
		case "hijab_beard":
			if(user.getHijabBeard()!= null && !user.getHijabBeard().equals("preferN")) {
				query = query + " and ";
				query = query + column + "='" + user.getHijabBeard() + "' or " +column+ "='dontmind'";
			}
			column = "pray";
		case "pray":
			if(user.getPray()!= null) {
				query = query + " and ";
				query = query + column + "='" + user.getPray() + "' or " +column+ "='dontmind'";
			}
			column = "sect";
		case "sect":
			if(user.getSect()!= null && !user.getSect().equals("preferN")) {
				query = query + " and ";
				query = query + column + "='" + user.getSect() + "' or " +column+ "='dontmind'";
			}
			column = "maritalstatus";
		case "maritalstatus":
			if(user.getMaritalStatus()!= null && !user.getMaritalStatus().equals("preferN")) {
				query = query + " and ";
				query = query + column + "='" + user.getMaritalStatus() + "' or " +column+ "='dontmind'";
			}
			column = "profession";
		case "profession":
			if(user.getProfession()!= null) {
				query = query + " and ";
				query = query + column + "='" + user.getProfession() + "' or " +column+ "='dontmind'";
			}
			column = "AgeRange";
		case "AgeRange":
			for(int i=0; i<agerange[0].length; i++) {
				query = query + " and ";
				query = query +user.getAge(user.getDob())+ " between '" +agerange[0][i]+ "' and '" +agerange[1][i]+ "' ";
			}
			column = "HeightRange";
		case "HeightRange":
			for(int i=0; i<heightrange[0].length; i++) {
				query = query + " and ";
				query = query +user.getHeight()+ " between '" +heightrange[0][i]+ "' and '" +heightrange[1][i]+ "' ";
			}
		}
		
		return query;
	}
	
	
	public String constructQuery(List<Long> userIds, String matchGender) {
		int fl = 0;
		int i = 0;
		String query = "select * from hl_users where ";
		if(userIds.get(0) != null) {
			for(Long id:userIds) {
				fl = 1; if(fl == 1 && i != 0) query = query + " or ";
				query = query + "(userId='" + id + "' and gender='" + matchGender + "') ";
				i++;
			}
		}
		return query;
	}
	
	// from javatpoint.com/example-of-sending-email-using-java-mail-api
	public void sendEmail(String recepient, String msgkey, String messageContent) throws MessagingException {
		System.out.println("Preparing Email.....");
		//get the session object
		Properties properties = new Properties();
		//Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");
        // gmail address
        final String myAccountEmail = "izawaj.sd@gmail.com";
        // gmail password
        final String password = "happyLife";
        
        //Create a session with account credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        
        //Prepare email message
        Message message = prepareMessage(session, myAccountEmail, recepient, msgkey, messageContent);
		
        //Send mail
        
			Transport.send(message);
        System.out.println("Message sent successfully");
	}
	
	private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String messageKey, String messageContent) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            String htmlCode;
            switch(messageKey) {
            case "toapprove":
            	String admin = "ahdmirghany@gmail.com";
            	//String admin1 = "ahdmirghany@gmail.com";
            	message.setRecipient(Message.RecipientType.TO, new InternetAddress(admin));
                message.setSubject("One message to Approve");
                
                message.setContent(messageContent, "text/html");
            	break;
            case "sent":
            	message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
                message.setSubject("Your message is sent");
                
                message.setContent(messageContent, "text/html");
            	break;
            case "read":
            	message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
                message.setSubject("Your message have been viewed.");
                
                message.setContent(messageContent, "text/html");
            	break;
            case "reply":
            	message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
                message.setSubject("You have got a new reply to your message");
                
                message.setContent(messageContent, "text/html");
            	break;
            case "viewed":
            	message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
                message.setSubject("Your profile have been viewed.");
                
                message.setContent(messageContent, "text/html");
            	break;
            }
            //message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            //message.setSubject("My First Email from Java App");
            //String htmlCode = "<h1> WE LOVE JAVA </h1> <br/> <h2><b>Next Line </b></h2>";
            //message.setContent(htmlCode, "text/html");
            return message;
        } catch (Exception ex) {
        	System.out.println(ex);
        	//Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
