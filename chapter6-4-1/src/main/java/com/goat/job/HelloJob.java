package com.goat.job;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class HelloJob implements BaseJob {  
  
    private static Logger _log = LoggerFactory.getLogger(HelloJob.class);  

    public void execute(JobExecutionContext context) {
        _log.error("Hello Job执行时间: " + new Date());
    }
}  
