package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/hello")
public class HelloContorller {

    @GetMapping
    public String hello(){
        Logger logger = LoggerFactory.getLogger(HelloContorller.class);
        logger.info("有人访问了hello页面！");
        return "index";
    }

}


