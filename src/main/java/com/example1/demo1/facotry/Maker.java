package com.example1.demo1.facotry;


import com.example1.demo1.sample.Qsample;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
// import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.stereotype.Service;

@Service
public class Maker {

    public static JobDetail buildJobDeatil(Class<Qsample> jobClass) {
         JobDataMap jobDataMap = new JobDataMap();
         jobDataMap.put(jobClass.getSimpleName(), jobClass.getName());

        // JobDetail
        return JobBuilder
        .newJob(Qsample.class)
        .withIdentity(jobClass.getSimpleName())
        .setJobData(jobDataMap)
        .build();
     }

     public static Trigger buildTrigger(Class<Qsample> jobClass ){
      
      CronScheduleBuilder schedulerBuild = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");

       return  TriggerBuilder
       .newTrigger()
       .withIdentity(jobClass.getSimpleName())
       .withSchedule(schedulerBuild)
       .build();
   
     }
       
}
    

