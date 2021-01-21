package com.ifreedom.freedom.reflectpack;

/**
 * @Author: freedom
 * @Date: 2020-11-16 09:46
 **/
public class SmallPineapple {
    public String name;
    public int age;
    private double weight; // ֛只有自己知道

    private static int times = 0;
    public SmallPineapple() {
        //构造器被调用的时候会打印出次数
        System.out.println("单例构造器被调用"+(++times)+"两次");

    }

    public SmallPineapple(String name, int age) {
        this.name = name; this.age = age;
    }
    public void getInfo() {

        System.out.println("["+ name + "的 age是" + age + "]");
    }
}
