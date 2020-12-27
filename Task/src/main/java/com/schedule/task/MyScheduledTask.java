package com.schedule.task;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyScheduledTask {

    //cron表达式
    @Scheduled(cron = "0/2 * * * * ?")
    public void doSome(){
        System.out.println("定时任务执行了: "+new Date());
    }


}
