package com.happylife.dao.registry;

import com.happylife.dao.implementation.AdminDAOImpl;
import com.happylife.dao.implementation.LookingForDAOImpl;
import com.happylife.dao.implementation.MessageApprovalDAOImpl;
import com.happylife.dao.implementation.MessageDAOImpl;
import com.happylife.dao.implementation.ResetDAOImpl;
import com.happylife.dao.implementation.UserDAOImpl;
import com.happylife.dao.implementation.ViewedDAOImpl;
import com.happylife.dao.layer.AdminDAO;
import com.happylife.dao.layer.LookingForDAO;
import com.happylife.dao.layer.MessageApprovalDAO;
import com.happylife.dao.layer.MessageDAO;
import com.happylife.dao.layer.ResetDAO;
import com.happylife.dao.layer.UserDAO;
import com.happylife.dao.layer.ViewedDAO;
import com.happylife.pojo.LookingFor;

public class RegistryDAO {
	public static UserDAO userDAO;
	public static MessageDAO messageDAO;
	public static LookingForDAO lookingForDAO;
	public static ViewedDAO viewedDAO;
	public static ResetDAO resetDAO;
	public static AdminDAO adminDAO;
	public static MessageApprovalDAO messageApprovalDAO;
	
	static{
		userDAO = new UserDAOImpl();
	}

	public static UserDAO getUserDAO() {
		return userDAO;
	}
	
	public static void setUserDAO(UserDAO userDAO) {
		RegistryDAO.userDAO = userDAO;
	}
	
	static{
		messageDAO = new MessageDAOImpl();
	}
	
	static {
		adminDAO = new AdminDAOImpl();
	}

	public static MessageDAO getMessageDAO() {
		return messageDAO;
	}

	public static void setMessageDAO(MessageDAO msgDAO) {
		RegistryDAO.messageDAO = msgDAO;
	}
	
	static {
		lookingForDAO = new LookingForDAOImpl();
	}
	
	public static LookingForDAO getLookingForDAO() {
		return lookingForDAO;
	}
	
	public static void setLookingForDAO(LookingForDAO lookingForDao) {
		RegistryDAO.lookingForDAO = lookingForDao;
	}
	
	static{
		viewedDAO = new ViewedDAOImpl();
	}
	
	public static ViewedDAO getViewedDAO() {
		return viewedDAO;
	}
	
	public static void setViewedDAO(ViewedDAO viewedDAO) {
		RegistryDAO.viewedDAO = viewedDAO;
	}
	
	static{
		resetDAO = new ResetDAOImpl();
	}

	public static ResetDAO getResetDAO() {
		return resetDAO;
	}
	
	public static void setResetDAO(ResetDAO resetDAO) {
		RegistryDAO.resetDAO = resetDAO;
	}
	
	static{
		adminDAO = new AdminDAOImpl();
	}

	public static AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public static void setAdminDAO(AdminDAO adminDAO) {
		RegistryDAO.adminDAO = adminDAO;
	}
	
	static{
		messageApprovalDAO = new MessageApprovalDAOImpl();
	}

	public static MessageApprovalDAO getMessageApprovalDAO() {
		return messageApprovalDAO;
	}

	public static void setMessageApprovalDAO(MessageApprovalDAO mssageApprovalDAO) {
		RegistryDAO.messageApprovalDAO = mssageApprovalDAO;
	}
}