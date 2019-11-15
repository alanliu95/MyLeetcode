package com.alan.tool.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class SimpleTriggerRunner {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        //创建一个jobDetail的实例，将该实例与HelloJob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob2.class).withIdentity("myJob").build();
        //创建一个Trigger触发器的实例，定义该job立即执行，并且每2秒执行一次，一直执行
        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
        //创建schedule实例
        StdSchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
//            Thread.sleep(10000);
//            System.out.println("end");
    }

}

class SimpleJob2 implements Job {
    @Override
    public void execute(JobExecutionContext jobCtx) throws JobExecutionException {
        System.out.println(" triggered. time is:" + new Date());
    }
}