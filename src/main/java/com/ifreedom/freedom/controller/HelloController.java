package com.ifreedom.freedom.controller;


import com.ifreedom.freedom.servicepack.HelloService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("当前时间" + new Date());
        helloService.printString();
        return String.format("Hello %s!", name);
    }
}
