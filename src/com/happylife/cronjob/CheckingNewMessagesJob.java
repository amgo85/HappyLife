package com.happylife.cronjob;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.happylife.dao.implementation.MessageDAOImpl;
import com.happylife.dao.layer.MessageDAO;
import com.happylife.dao.layer.MessageDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.Messages;


public class CheckingNewMessagesJob implements Job{
	static Logger log = Logger.getLogger(CheckingNewMessagesJob.class.getName());
	
	public List<Messages> checkInboxfor(long userId) {
		List<Messages> unReadList = null;
		try {
			//List<Messages> unReadList = messageDAO.getUnRead(userId);
			unReadList = RegistryDAO .getMessageDAO().getUnRead(userId);
			for(Messages m: unReadList){
				System.out.println("Message " + m.getMessageId() + " is " + m.getMsgContent());
			}
			
			return unReadList;
		} catch (MessageDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return unReadList;
	}
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		log.info("Checking inbox for new messages! - " + new Date());
		System.out.println("Checking inbox for new Messages starts.."+new Date());
		
		List<Messages> unReadList = null;
		try {
			//List<Messages> unReadList = messageDAO.getUnRead(userId);
			unReadList = RegistryDAO.getMessageDAO().getUnRead();
			for(Messages m: unReadList){
				System.out.println("Message " + m.getMessageId() + " is " + m.getMsgContent());
			}
			
		unReadList = null;
		} catch (MessageDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
