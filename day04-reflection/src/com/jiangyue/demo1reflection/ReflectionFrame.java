package com.jiangyue.demo1reflection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class ReflectionFrame {
    public static void main(String[] args) throws Exception {
        Person person = new Person("Tom", 22);
        save(person);
        User user = new User(1, "Tom", 22, true);
        save(user);
    }

    public static void save(Object obj) throws Exception {
        PrintStream out = new PrintStream(new FileOutputStream("resource/info.txt", true));
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields(); // 获取所有属性（包括私有）
        for (Field field : fields) {
            field.setAccessible(true);
            String value = String.valueOf(field.get(obj));
            out.println(field.getName() + " = " + value);
            System.out.println(field.getName() + " = " + value);
        }
        out.close();
    }
}
