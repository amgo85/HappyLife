package com.happylife.cronjob;

import static org.quartz.TriggerBuilder.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.JobBuilder;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.DateBuilder.*;
// not used
public class CronListener implements ServletContextListener{
	Scheduler scheduler = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContext) {
		System.out.println("Context Destroyed");
		try {
			scheduler.shutdown();
		}catch(SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Context Initialized");

	    try {
	        // Setup the Job class and the Job group
	        JobDetail job = org.quartz.JobBuilder.newJob(HelloJob.class).withIdentity("CronQuartzJob",
	                "Webapp").build();

	        // Create a Trigger that fires every X minutes.
	        Trigger trigger = newTrigger()
	                .withIdentity("CronQuartzJob", "Sauver")
	                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/6 * 1/1 * ? *")).build();


	        // Setup the Job and Trigger with Scheduler & schedule jobs
	        scheduler = new StdSchedulerFactory().getScheduler();
	        scheduler.start();
	        scheduler.scheduleJob(job, trigger);
	    } catch (SchedulerException e) {
	        e.printStackTrace();
	    }
	}
}
