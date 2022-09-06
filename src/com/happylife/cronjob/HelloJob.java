package com.happylife.cronjob;

import java.util.Date;
import java.util.logging.Logger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job{
	static Logger log = Logger.getLogger(HelloJob.class.getName());
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// Say Hello to the World and display the date/time
		log.info("Hello World! - " + new Date());
		System.out.println("Trigger Starts.."+new Date());
	}
}


