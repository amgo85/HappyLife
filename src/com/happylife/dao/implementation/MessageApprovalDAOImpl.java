package com.happylife.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.happylife.dao.layer.MessageApprovalDAO;
import com.happylife.dao.layer.MessageApprovalDAOException;
import com.happylife.pojo.Admin;
import com.happylife.pojo.Messages;

public class MessageApprovalDAOImpl implements MessageApprovalDAO {
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;

	@Override
	public String approveMessage(long msgId, int adminId, boolean status) throws MessageApprovalDAOException {
		try {
			conn = DatabaseConnectivity.doDBConnection();
			// pstmt = conn.prepareStatement("update Message_Approval set msgApproved=?, adminId=? where msgId=?");	// old plan
			pstmt = conn.prepareStatement("insert into Message_Approval values (?,?,?)");
			pstmt.setLong(1,msgId);
			pstmt.setInt(2,adminId);
			pstmt.setBoolean(3,true);
			pstmt.execute();
			
			return "MessageApproval Status updated Successfully...";
		}catch(Exception e) {
			e.printStackTrace();
			return "Something went wrong in Message Approval, please try again ! ! !";
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
	}

	@Override
	public List<Long> getAllApproved() throws MessageApprovalDAOException {
		List<Long> approvedMsgIds = new ArrayList<Long>();
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("select msgId from Message_Approval where msgApproved=?");
			pstmt.setBoolean(1,true);
			//pstmt.executeUpdate();
			pstmt.executeQuery();
			while (rs.next()){
				long msgId  = rs.getLong(1);
				
				approvedMsgIds.add(msgId);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		
		return approvedMsgIds;
	}
	
	@Override
	public List<Long> getAllApproved(int adminId) throws MessageApprovalDAOException {
		List<Long> approvedMsgIds = new ArrayList<Long>();
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("select msgId from Message_Approval where msgApproved=? and adminId=?");
			pstmt.setBoolean(1,true);
			pstmt.setInt(2,adminId);
			//pstmt.executeUpdate();
			rs = pstmt.executeQuery();
			while (rs.next()){
				long msgId  = rs.getLong(1);
				
				approvedMsgIds.add(msgId);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		
		return approvedMsgIds;
	}

	@Override
	public List<Long> getAllBlocked() throws MessageApprovalDAOException {		// You should make one more status called "blocked"
		List<Long> blockedMsgIds = new ArrayList<Long>();
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("select msgId from Message_Approval where msgApproved=?");
			pstmt.setBoolean(1,false);
			pstmt.executeUpdate();
			while (rs.next()){
				long msgId  = rs.getLong(1);
				
				blockedMsgIds.add(msgId);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		
		return blockedMsgIds;
	}

	@Override
	public List<Long> getAllToApprove() throws MessageApprovalDAOException {
		// TODO Auto-generated method stub
		return null;
	}
}
