package com.jiangyue.demo1api;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UseDate {
    public static void main(String[] args){
        // 目标：掌握 Java 提供的获取时间方案
        // Goal: Understand how to get time in Java
        // JDK 8 之前的方案：Date 获取此刻日期时间（老项目还在使用）
        // Before JDK 8: Date get current time (old project still uses)
        Date d = new Date();
        System.out.println(d);

        // 格式化：SimpleDateFormat 简单日期格式化，格式化日期对象成我们想要的格式
        // Format: SimpleDateFormat Simple date formating, format date object to our desired format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = sdf.format(d);
        System.out.println(result);

        // JDK 8 之后的方案：LocalDate, LocalTime, LocalDateTime 获取此刻日期时间（新项目推荐）
        // After JDK 8: LocalDate, LocalTime, LocalDateTime get current time (new project recommended)
        // 获取此刻时间对象
        // Get current time object
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getYear());
        System.out.println(now.getDayOfYear());

        // 格式化：DateTimeFormatter
        // Format: DateTimeFormatter
        // 1、创建一个格式化对象
        // 1、Create a formatter object
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EEE a");
        // 2、格式化 now 对象的时间
        // 2、Format now object's time
        String result2 = dtf.format(now);
        System.out.println(result2);
    }
}
