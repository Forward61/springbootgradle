package com.ifreedom.freedom.servicepack;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class HelloService {
    public  void printString(){
        System.out.println("我是service 的print方法");
    }
}
