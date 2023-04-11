package os.g.zone.messages.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import os.g.zone.messages.quartz.MessagesQuartzJob;
import os.g.zone.messages.quartz.ReportsQuartzJob;

/**
 * @Auther: AA
 * @Date: 2023/4/10 01:18
 * @Description: QuartzConfig
 * @Version 1.0.0
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail updateReportsJob(){

        return JobBuilder.newJob(ReportsQuartzJob.class)
                .withIdentity("updateReportsJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger updateReportsJobTrigger(){
        CronScheduleBuilder cron=
                CronScheduleBuilder.cronSchedule("0/3 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(updateReportsJob())
                .withSchedule(cron)
                .withIdentity("updateReportsJobTrigger")
                .build();
    }

    @Bean
    public JobDetail updateMessagesQuartzJob(){

        return JobBuilder.newJob(MessagesQuartzJob.class)
                .withIdentity("updateMessagesQuartzJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger updateMessagesQuartzJobTrigger(){
        CronScheduleBuilder cron=
                CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(updateMessagesQuartzJob())
                .withSchedule(cron)
                .withIdentity("updateMessagesQuartzJobTrigger")
                .build();
    }
}
