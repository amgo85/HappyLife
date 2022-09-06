package com.happylife.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.happylife.DoMath;
import com.happylife.dao.layer.LookingForDAOException;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.layer.ViewedDAO;
import com.happylife.dao.layer.ViewedDAOException;
import com.happylife.pojo.User;
import com.happylife.pojo.Viewed;

public class ViewedDAOImpl implements ViewedDAO{
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;
	

	@Override
	public String insertViewed(Viewed v) throws ViewedDAOException {
		boolean status = false;
		String viewedStatus = "";
		System.out.println("Has user1 viewed user2 ? "+ v.hasUser1vieweduser2());
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("insert into viewed values (?,?,?,?,?,?,?,?) ");
			
			pstmt.setLong(1,v.getId());
			pstmt.setLong(2,v.getUid1());
			pstmt.setLong(3,v.getUid2());
			pstmt.setString(4,v.getHistoryContent());
			pstmt.setBoolean(5,v.hasUser1vieweduser2());
			pstmt.setBoolean(6,v.hasUser2vieweduser1());
			pstmt.setBoolean(7,v.hasUser1inviteduser2());
			pstmt.setBoolean(8,v.hasUser2inviteduser1());
			status = pstmt.execute();
			
			viewedStatus =  "viewed record inserted Successfully...";
		}catch(SQLException e) {
			System.out.println(e);
			viewedStatus =  "Something went wrong with insertion please try again ! ! !";
		}
		
		return viewedStatus;
	}
	
	@Override
	public String checkIfRecordExists(long uid1, long uid2) throws ViewedDAOException {
		String historyRecord = "Not Found";
		boolean isFound = false;
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("select historyContent from Viewed where (uid1=? and uid2=?) or (uid1=? and uid2=?)");
			pstmt.setLong(1,uid1);
			pstmt.setLong(2,uid2);
			pstmt.setLong(3,uid2);					
			pstmt.setLong(4,uid1);
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				historyRecord  = rs.getString(1);
			}
			System.out.println("Inside checkIfRecordExists: histroy record between " +uid1 + " & "+ uid2 +" is:\n"+ historyRecord);
			if(!historyRecord.equalsIgnoreCase("NotFound")) isFound = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		System.out.println("A record is found in the Viewed table? " + isFound);
		return historyRecord;
	}
	
	@Override
	public String updateViewed(long uid1, long uid2, String ...v) throws ViewedDAOException {
		String msg = "";
		if (v.length %2 != 0) return "wrong number of arguments, number of Arguments must be even";
		
		try {
			conn = DatabaseConnectivity.doDBConnection();
			for(int i=0 ; i< v.length; i+=2) {
				switch(v[i]) {
				case "record":
					//pstmt = conn.prepareStatement("select concat(historyContent, ' Hassan viewed Asma profile') AS historyContent FROM `viewed` where uid1='4'");
					pstmt = conn.prepareStatement("update viewed set historyContent=? where (uid1=? and uid2=?) or (uid1=? and uid2=?)");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,uid1);
					pstmt.setLong(3,uid2);
					pstmt.setLong(4,uid2);					
					pstmt.setLong(5,uid1);
					pstmt.executeUpdate();
					msg = msg + "\nUser with '"+uid1+"' viewed user with '"+uid2+"' Updated Successfully";
					System.out.println(msg);
					break;
				case "u1vu2":
					pstmt = conn.prepareStatement("update viewed set user1vieweduser2=? where (uid1=? and uid2=?) or (uid1=? and uid2=?)");
					pstmt.setBoolean(1,Boolean.parseBoolean(v[i+1]));
					pstmt.setLong(2,uid1);
					pstmt.setLong(3,uid2);
					pstmt.setLong(4,uid2);					
					pstmt.setLong(5,uid1);
					pstmt.executeUpdate();
					msg = msg + "\nUser with '"+uid1+"' viewed user with '"+uid2+"' Updated Successfully";
					System.out.println(msg);
					break;
				case "u2vu1":
					pstmt = conn.prepareStatement("update viewed set user2vieweduser1=? where (uid1=? and uid2=?) or (uid1=? and uid2=?)");
					pstmt.setBoolean(1,Boolean.parseBoolean(v[i+1]));
					pstmt.setLong(2,uid1);
					pstmt.setLong(3,uid2);
					pstmt.setLong(4,uid2);					
					pstmt.setLong(5,uid1);
					pstmt.executeUpdate();
					msg = msg + "\nUser with '"+uid2+"' viewed user with '"+uid1+"' Updated Successfully";
					break;
				case "u1invitedu2":
					pstmt = conn.prepareStatement("update viewed set user1inviteduser2=? where (uid1=? and uid2=?) or (uid1=? and uid2=?)");
					pstmt.setBoolean(1,Boolean.parseBoolean(v[i+1]));
					pstmt.setLong(2,uid1);
					pstmt.setLong(3,uid2);
					pstmt.setLong(4,uid2);					
					pstmt.setLong(5,uid1);
					pstmt.executeUpdate();
					msg = msg + "\nUser with '"+uid1+"' invited user with '"+uid2+"' to view their profile Updated Successfully";
					break;
				case "u2invitedu1":
					pstmt = conn.prepareStatement("update viewed set user2inviteduser1=? where (uid1=? and uid2=?) or (uid1=? and uid2=?)");
					pstmt.setBoolean(1,Boolean.parseBoolean(v[i+1]));
					pstmt.setLong(2,uid1);
					pstmt.setLong(3,uid2);
					pstmt.setLong(4,uid2);					
					pstmt.setLong(5,uid1);
					pstmt.executeUpdate();
					msg = msg + "\nUser with '"+uid2+"' invited user with '"+uid1+"' to view their profile Updated Successfully";
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "Something went wrong please try again ! ! !";
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return msg;
	}
	
	// I may need it, if I don't I will delete it
	//@Override
	public String inviteToViewProfile(long userId, long candidId)throws UserDAOException{
		String invited = "";
		try {
			conn = DatabaseConnectivity.doDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("select my_fav from HL_USERS where userId=?");
			pstmt.setLong(1,userId);
			rs = pstmt.executeQuery();
			while (rs.next()){
				invited  = rs.getString(1);
			}
			System.out.println("inside getMyFavorites(), is " + invited);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return invited;
	}

	@Override
	public List<Viewed> getViewedForUser(long userId, String gender) throws ViewedDAOException {
		List<Viewed> viewedList = new ArrayList<Viewed>();
		
		try {
			System.out.println("Inside getViewedForUser()");
			conn = DatabaseConnectivity.doDBConnection();
			if(gender.equals("M")) {
				pstmt = conn.prepareStatement("select * from viewed where uid1=? and user2vieweduser1=true");
				pstmt.setLong(1,userId);
			}else {
				pstmt = conn.prepareStatement("select * from viewed where uid2=? and user1vieweduser2=true");
				pstmt.setLong(1,userId);
			}
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				long id  = rs.getLong(1);					
				long uid1  = rs.getLong(2);				
				long uid2  = rs.getLong(3);					
				String historyContent  = rs.getString(4);				
				boolean u1ViewedU2 = rs.getBoolean(5);
				boolean u2ViewedU1 = rs.getBoolean(6);
				boolean u1InvitedU2 = rs.getBoolean(7);
				boolean u2InvitedU1 = rs.getBoolean(8);
				
				Viewed v = new Viewed(id, uid1, uid2, historyContent, u1ViewedU2, u2ViewedU1, u1InvitedU2, u2InvitedU1);
				viewedList.add(v);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return viewedList;
	}

}
