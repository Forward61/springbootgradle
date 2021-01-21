package com.ifreedom.freedom.reflectpack;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author: freedom
 * @Date: 2020-11-16 10:44
 **/
public class Bootstrap {
    public static void execute(String path) throws Exception {
        Class obj = Class.forName(path);
        Method method = obj.getMethod("getInfo");
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation  "  + annotation.toString());
        }
        Class clazz = Class.forName(path);
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        constructor.setAccessible(true);
        BigPineapple sp = (BigPineapple) constructor.newInstance("大菠萝", 21);
        Method method2 = clazz.getMethod("getInfo");
        if (method2 != null) {
            method2.invoke(sp, null);
        }
    }

    public static void main(String[] args) throws Exception {
        execute("com.ifreedom.freedom.reflectpack.BigPineapple");
    }
}
