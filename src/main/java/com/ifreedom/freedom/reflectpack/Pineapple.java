package com.ifreedom.freedom.reflectpack;

/**
 * @Author: freedom
 * @Date: 2020-11-16 10:28
 **/
public abstract class Pineapple {
    public String name;
    public int age;
    public int height;
    public abstract void getInfo();
    public Pineapple(String name,int age){
        this.name = name;
        this.age = age;
    }
}
