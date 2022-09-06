package com.happylife.dao.layer;

import java.util.List;

import com.happylife.pojo.Admin;

public interface MessageApprovalDAO {
	String approveMessage(long msgId, int admidId, boolean b) throws MessageApprovalDAOException;
	List<Long> getAllApproved() throws MessageApprovalDAOException;
	List<Long> getAllApproved(int adminId) throws MessageApprovalDAOException;
	List<Long> getAllBlocked() throws MessageApprovalDAOException;
	List<Long> getAllToApprove() throws MessageApprovalDAOException;
}
