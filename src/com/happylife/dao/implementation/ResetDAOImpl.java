package com.happylife.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.happylife.dao.layer.ResetDAO;
import com.happylife.dao.layer.ResetDAOException;

public class ResetDAOImpl implements ResetDAO{
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;

	@Override
	public String activateAccount(String emailId, String token) throws ResetDAOException {
		boolean status;
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("insert into RESET_PASS values (?,?,?) ");
			pstmt.setString(1,token);
			pstmt.setString(2,emailId);
			java.util.Date date = new java.util.Date();
			long time = date.getTime();
			Timestamp ts = new Timestamp(time);
			pstmt.setTimestamp(3,ts);
			status = pstmt.execute();
			
			return Boolean.toString(status);
		}catch(Exception e) {
			e.printStackTrace();
			throw new ResetDAOException(e.getMessage());
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
	}
	
	@Override
	public String addResetLink(String email) throws ResetDAOException {
		String token = java.util.UUID.randomUUID().toString();
		String link;
		try {
			conn = DatabaseConnectivity.doDBConnection();	//update RESET_PASS set token=? where email=?
			pstmt = conn.prepareStatement("update RESET_PASS set token=? where email=?");
			pstmt.setString(1,token);
			pstmt.setString(2,email);
			pstmt.executeUpdate();
			link = token;
			return link;
		}catch(Exception e) {
			e.printStackTrace();
			throw new ResetDAOException(e.getMessage());
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
	}

	@Override
	public String validateToken(String token) throws ResetDAOException {
		String fetchedUserEmail;
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("select * from RESET_PASS where Token=? ");
			pstmt.setString(1,token);
			
			String query = "SELECT * FROM RESET_PASS WHERE TOKEN = '" +token+ "'";
			System.out.println("The ValidateToken query is: " +query+ "\nToken " +token+ " is verified from the table...");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				fetchedUserEmail = rs.getString(1);
				System.out.println("UserId: " +fetchedUserEmail);
				return fetchedUserEmail;
			} else {
				throw new ResetDAOException("Token Not found");
			}
		} catch(Exception e){
			e.printStackTrace();
			throw new ResetDAOException(e.getMessage());
		} finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
	}
}
