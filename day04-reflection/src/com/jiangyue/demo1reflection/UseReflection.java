package com.jiangyue.demo1reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class UseReflection {
    public static void main(String[] args) {
        // 获取 Class 本身
        Class c1 = User.class;
        System.out.println(c1);
        // 获取类本身：Class.forName("类的全类名")
        try {
            Class c2 = Class.forName("com.jiangyue.demo1reflection.User");
            System.out.println(c2);
            System.out.println(c1 == c2);
        } catch (ClassNotFoundException e) {
            System.out.println("==========");
            System.out.println("Class not found");
            e.printStackTrace();
        }
        // 获取类本身：对象.getClass()
        User user = new User();
        Class c3 = user.getClass();
        System.out.println(c3);
        System.out.println(c1 == c3);

        // 获取类的构造器对象：Class.getConstructors()
        // 返回一个 构造器列表
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + " : " + constructor);
        }

        // 获取无参构造器
        try {
            System.out.println(c1.getConstructor().getName() + " : " + c1.getConstructor());
        } catch (Exception e) {
            System.out.println("==========");
            e.printStackTrace();
        }

        // 获取一个有参构造器
        try {
            Constructor constructor = c1.getConstructor(int.class, String.class, int.class, boolean.class);
            System.out.println(constructor.getName() + " : " + constructor);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 强转 User 的 private 无参构造器为ganging的构造器
        try {
            Constructor constructor = c1.getDeclaredConstructor();
            constructor.setAccessible(true);
            user = (User) constructor.newInstance();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 利用反射绕过泛型的约束
        useReflectionAvoidGeneric();
    }

    public static void useReflectionAvoidGeneric() {
        String s1 = "avoid";
        User u1 = new User();
        try {
            Method show1 = u1.getClass().getMethod("show", Object.class);
            show1.invoke(u1, s1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
