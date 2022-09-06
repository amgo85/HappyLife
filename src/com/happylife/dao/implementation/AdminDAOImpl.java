package com.happylife.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.happylife.dao.layer.AdminDAO;
import com.happylife.dao.layer.AdminDAOException;
import com.happylife.pojo.Admin;
import com.happylife.pojo.User;

public class AdminDAOImpl implements AdminDAO {
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;
	
	@Override
	public Admin doLogin(String email, String password) throws AdminDAOException {
		Admin adminToFetch = null;
		
		try{
			conn = DatabaseConnectivity.doDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from Admins where EMAIL=? and PASSWD=?"); 
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			
			rs = pstmt.executeQuery();
			
			System.out.println("select count(*) from Admins where EMAIL='"+email+"' and PASSWD='"+password+"'");
			int columnCount = 0;
			while(rs.next()){
				for (int i = 1; i <= columnCount; i++ ) {
					  String name = rs.getMetaData().getColumnName(i);
					  System.out.println("Column name: "+ name);
					}
				int adminId  = rs.getInt(1);					//rs.getInt("adminId");
				String emailId  = rs.getString(2);				//rs.getString("EMAIL");
				String fname  = rs.getString(3);				//rs.getString("FNAME");
				String lname = rs.getString(4);					//rs.getString("LNAME");
				String uname  = rs.getString(5);				//rs.getString("username");
				String pass  = rs.getString(6);					//rs.getString("PASSWD");
				String gender  = rs.getString(7);				//rs.getString("GENDER");
				Date dob = rs.getDate(8);
				String phone  = rs.getString(9);				//rs.getString("PHONE");
				Admin admin = new Admin(adminId, emailId, fname, lname, uname, pass, gender, dob, phone);
				adminToFetch = admin;
			}
			
			if(adminToFetch == null){
				throw new AdminDAOException("Admin not found");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return adminToFetch;
	}

	@Override
	public String doSignUp(Admin admin) throws AdminDAOException {
		boolean status = false;
		String signupStatus = "";
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("insert into Admins values (?,?,?,?,?,?,?,?,?) ");
			
			pstmt.setInt(1,admin.getAdminId());
			pstmt.setString(2,admin.getEmail());
			pstmt.setString(3,admin.getFname());
			pstmt.setString(4,admin.getLname());
			pstmt.setString(5,admin.getUsername());
			pstmt.setString(6,admin.getPassword());
			pstmt.setString(7,admin.getGender());
			pstmt.setDate(8,admin.getDob());
			pstmt.setString(9,admin.getPhone());
			status = pstmt.execute();
			signupStatus =  "Admin Signup Successfully...";
		}catch(SQLException e) {
			System.out.println(e);
			signupStatus =  "Something went wrong with admin signup please try again ! ! !";
		}
		
		return signupStatus;
	}
}
