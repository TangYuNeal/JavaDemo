package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
public class ScheduleConfiguraiton {
    //@Scheduled(fixedDelay = 2000)
    //秒 分 时 日 月 星期 年
    @Scheduled(cron = "0 0 0 */1 * *")
    public void testSchedule() throws InterruptedException {
        System.out.println("我是定时任务！" + new Date());
    }
}
