package com.example.controller;

import com.example.event.TestEvent;
import com.example.service.AsyncService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;

@RestController
@RequestMapping("/hello")
public class HelloContorller {

    @Resource
    AsyncService asyncService;
    @Resource
    ApplicationContext context;



    @GetMapping
    public String hello() {
        //日志
        Logger logger = LoggerFactory.getLogger(HelloContorller.class);
        logger.info("有人访问了hello页面！");
        //异步
        asyncService.test();
        System.out.println("Hello,我是同步任务！" + new Date());
        //监听
        context.publishEvent(new TestEvent("Hello!"));
        return "index";
    }
}


