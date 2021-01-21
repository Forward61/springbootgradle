package com.ifreedom.freedom.reflectpack;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: freedom
 * @Date: 2020-11-16 09:49
 **/
public class MainC {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz1 = Class.forName("com.ifreedom.freedom.reflectpack.SmallPineapple");
        Class clazz2 = SmallPineapple.class;
        SmallPineapple instance = new SmallPineapple();
        Class clazz3 = instance.getClass();
        System.out.println("Class.forName() == SmallPineapple.class:" + (clazz1 == clazz2));
        System.out.println("Class.forName() == instance.getClass():" + (clazz1 == clazz3));
        System.out.println("instance.getClass() == SmallPineapple.class:" + (clazz2 == clazz3));

        SmallPineapple smallPineapple = (SmallPineapple) clazz1.newInstance();
        smallPineapple.getInfo();

        Constructor constructor = clazz1.getConstructor(String.class,int.class);
        //constructor.setAccessible(true);


        SmallPineapple smallPineapple2 = (SmallPineapple) constructor.newInstance("小明", 21);
        smallPineapple2.getInfo();
        SmallPineapple smallPineapple3 = (SmallPineapple) clazz3.newInstance();
        smallPineapple3.getInfo();

    }
}
