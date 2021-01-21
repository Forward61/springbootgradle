package com.ifreedom.freedom.reflectpack;

import java.beans.Transient;

/**
 * @Author: freedom
 * @Date: 2020-11-16 10:29
 **/
public class BigPineapple extends Pineapple {

    public BigPineapple(String name, int age) {
        super(name, age);
    }

    @Transient
    @Override
    public void getInfo() {
        System.out.print("小菠萝的身高，年龄是:" + height + "cm ; " + age + "岁");
    }
}
