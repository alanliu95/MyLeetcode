package com.alan.tool.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class SimpleJob implements Job {
    @Override
    public void execute(JobExecutionContext jobCtx) throws JobExecutionException {
        System.out.println(" triggered. time is:" + new Date());
    }
}
