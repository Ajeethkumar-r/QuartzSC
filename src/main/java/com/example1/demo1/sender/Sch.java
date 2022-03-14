package com.example1.demo1.sender;

import com.example1.demo1.facotry.Maker;
import com.example1.demo1.sample.Qsample;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

@Service
public class Sch {
    
    public void iamRunnig(){

    JobDetail jobDetail = Maker.buildJobDeatil(Qsample.class);
    Trigger trigger = Maker.buildTrigger(Qsample.class);

    try {
        Scheduler sc = StdSchedulerFactory.getDefaultScheduler();
        sc.scheduleJob(jobDetail, trigger);
        sc.start();
    } catch (Exception e) {
        e.printStackTrace();
    }

}

}
