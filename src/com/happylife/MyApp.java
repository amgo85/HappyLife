package com.happylife;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.happylife.dao.implementation.LookingForDAOImpl;
import com.happylife.dao.implementation.MessageDAOImpl;
import com.happylife.dao.implementation.UserDAOImpl;
import com.happylife.dao.implementation.ViewedDAOImpl;
import com.happylife.dao.layer.LookingForDAO;
import com.happylife.dao.layer.MessageDAO;
import com.happylife.dao.layer.UserDAO;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.layer.ViewedDAO;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.LookingFor;
import com.happylife.pojo.Messages;
import com.happylife.pojo.User;
import com.happylife.pojo.Viewed;


public class MyApp {

	public static void main(String[] args) throws Exception {
		
		/*
		 * UserDAO userDAO = new UserDAOImpl(); List<User> list =
		 * userDAO.searchByLocation("F", args); Iterator<User> itr = list.iterator();
		 * while (itr.hasNext()){ User u = itr.next(); // why did you define this object
		 * inside the while loop; System.out.println(u.getUsername()); }
		 */
		
		/*
		 * DoMath doM = new DoMath(); String dateStr = "2011-06-12"; Timestamp ts =
		 * Timestamp.valueOf("2020-05-14 15:24:42"); Date date = Date.valueOf(dateStr);
		 * System.out.println("Date given by main is " + date); int age =
		 * doM.getAge(date); System.out.println("Age calulated by doMath is " + age);
		 * 
		 * Timestamp stamp = new Timestamp(System.currentTimeMillis());
		 * System.out.println("Timestamp in main " + stamp);
		 * System.out.println("Last Login " + doM.getLastLogin(ts));
		 */
		
		/*
		 * MessageDAO messageDao = new MessageDAOImpl(); List<Messages> mlist =
		 * messageDao.getChat(8, 1); Iterator<Messages> itr = mlist.iterator(); while
		 * (itr.hasNext()){ Messages m = itr.next(); System.out.println(m.getMessageId()
		 * + " " + m.getMsgContent()); }
		 */
		
		/*
		 * DoMath doM3 = new DoMath();
		 * 
		 * LookingFor lf = new LookingFor(17, 17, "Any", null, null, null, null, null,
		 * null, null, null, null, null, null, null, null, null, null, null, null, null,
		 * null, null, null);
		 * 
		 * LookingFor lf2 = new LookingFor(17, 17, "28", "40", "Sudan", "Citizen",
		 * "dontmind", "Arab", "dontmind", "wc", "4", "SS", "NM", null, null, null,
		 * null, "dontmind", "Any", "Any", "Yes", "Doctor", null, null); LookingForDAO
		 * lfdao = new LookingForDAOImpl(); String msg = lfdao.insertLookingFor(lf);
		 * System.out.println("lookingfor status: " + msg);
		 */
		
		/*
		 * String gender = "F"; UserDAO userDAO = new UserDAOImpl(); ViewedDAO viewedDAO
		 * = new ViewedDAOImpl(); List<Viewed> viewedMe = viewedDAO.getViewedForUser(4,
		 * gender); List<User> viewedList = new ArrayList<User>(); for(Viewed
		 * v:viewedMe) { User userViewedMe = new User();
		 * System.out.println(v.getHistoryContent()); if(gender.equals("M"))
		 * userViewedMe = userDAO.getUserByUserId(v.getUid2()); else userViewedMe =
		 * userDAO.getUserByUserId(v.getUid1()); viewedList.add(userViewedMe); // I need
		 * to add only three to the myprofile page }
		 */
		
		//DoMath doM = new DoMath();
		//doM.sendEmail("ahdmirghany@gmail.com", "", "");
		
		
		//String query = doM3.constructQueryL(lf, 25, "155");
		//System.out.println("Constructed Query in main is: " + query);
		 
		/*
		 * long arr[] = new long[] {1, 16, 34, 149, 17}; String query =
		 * doM3.constructQuery(arr, "F"); System.out.println("Constructed Query is: " +
		 * query);
		 */
		
		
		
		try {
			SchedulerFactory sf = new StdSchedulerFactory();
			Scheduler sched = sf.getScheduler();
			
			// define the job and tie it to our CheckingNewMessagesJob class, withIdentity("checkInboxJob", "group1")
			JobDetail checkInboxJob = org.quartz.JobBuilder.newJob(com.happylife.cronjob.CheckingNewMessagesJob.class)
			    .withIdentity("checkInboxJob", "session")
			    .build();
			
			// run 300 seconds only infinite loop
			SimpleTrigger simpletrigger = org.quartz.TriggerBuilder
					.newTrigger()
					.withIdentity("InfiniteTrigger", "session")
					.startNow()
					.withSchedule(SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(10)
					.withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY)).build();
			
			
			// Tell quartz to schedule the job using our trigger
			sched.scheduleJob(checkInboxJob, simpletrigger);
			
			sched.start();
			
		} catch (SchedulerException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		while(true) {
//			int sessionCounter = OnlineUsersCounter.getActiveSessionNumber();
//			
//			System.out.println("The number of online user: " + sessionCounter);
//			for(int i=0; i<65535*2; i++);
//		}
	}
}