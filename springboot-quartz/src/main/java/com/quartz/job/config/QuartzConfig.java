package com.quartz.job.config;

import com.quartz.job.MyJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(MyJob.class);
        return factoryBean;
    }

    /**
     * 创建Trigger对象
     * @return
     */
    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        // 关联JobDetail对象
        factoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        // 设置间隔时间
        factoryBean.setRepeatInterval(5000);
        // 设置重复次数
        factoryBean.setRepeatCount(10);
        return factoryBean;
    }
    /**
     * 创建Trigger对象 Cron表达式
     * 轮训的间隔时间
     * @return
     */
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        // 设置触发的时间
        factoryBean.setCronExpression("0/5 * * * * ?");
        return factoryBean;
    }

    /**
     * 创建对应的Scheduler对象
     * @param cronTriggerFactoryBean
     * @return
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean){
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        return factoryBean;
    }
}
