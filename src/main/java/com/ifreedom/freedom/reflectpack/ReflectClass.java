package com.ifreedom.freedom.reflectpack;

import javax.sound.midi.SoundbankResource;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: freedom
 * @Date: 2020-11-16 09:04
 **/
public class ReflectClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        HashMap hashMap = (HashMap) mapReflectMethod("java.util.HashMap");
        hashMap.put(1,1);
        System.out.println(hashMap.get(1));
        LinkedHashMap linkedHashMap = (LinkedHashMap) mapReflectMethod("java.util.LinkedHashMap");
        linkedHashMap.put(2,2);
        System.out.println(linkedHashMap.get(2));
        TreeMap treeMap = (TreeMap) mapReflectMethod("java.util.TreeMap");
        treeMap.put(3,3);
        System.out.println(treeMap.get(3));
    }


    public static Map<Integer, Integer> mapReflectMethod(String className) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName(className);
        Constructor con = clazz.getConstructor();
        return (Map<Integer, Integer>) con.newInstance();


    }
}
