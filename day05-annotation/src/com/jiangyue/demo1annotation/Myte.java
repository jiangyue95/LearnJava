package com.jiangyue.demo1annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Myte {
    public static void main(String[] args) throws Exception{
        // get the object of MyTest
        Myte mt = new Myte();
        // get class object
        Class clazz = Myte.class;
        // 遍历所有方法，判断方法上是否有 MyTest 注解，有则执行
        for (Method m : clazz.getDeclaredMethods()) {
            // 获取方法上的注解
            Annotation[] ans = m.getAnnotations();
            // 遍历注解，判断注解类型是否为 MyTest
            for (Annotation an : ans) {
                if (an instanceof MyTest) {
                    // 获取注解对象，并调用方法
                    MyTest mt1 = (MyTest) an;
                    for (int i = 0; i < mt1.count(); i++) {
                        m.invoke(mt);
                    }
                }
            }
        }
    }

    @MyTest
    public static void a1() {
        System.out.println("a1");
    }

    public static void a2() {
        System.out.println("a2");
    }

    @MyTest(count = 5)
    public static void a3() {
        System.out.println("a3");
    }
}
