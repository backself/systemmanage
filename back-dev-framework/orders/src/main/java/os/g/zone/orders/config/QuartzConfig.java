package os.g.zone.orders.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import os.g.zone.orders.quartz.AddOrdersJob;

/**
 * @Auther: AA
 * @Date: 2023/4/9 09:11
 * @Description: QuartzConfig
 * @Version 1.0.0
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail addOrdersJob(){

        return JobBuilder.newJob(AddOrdersJob.class)
                .withIdentity("addOrdersJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger addOrdersJobTrigger(){
        CronScheduleBuilder cron=
                CronScheduleBuilder.cronSchedule("0/3 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(addOrdersJob())
                .withSchedule(cron)
                .withIdentity("addOrdersJobTrigger")
                .build();
    }
}
