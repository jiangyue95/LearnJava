package com.jiangyue.demo1exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo5 {
    // 目标：掌握异常的处理方法1: 底层异常都抛出去给最外层调用者，最外层捕获异常，记录异常，响应合适信息给用户观看。
    public static void main(String[] args) {
        try {
            show();
        } catch (ParseException e) {
            e.printStackTrace(); // 打印异常信息
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void show() throws ParseException, FileNotFoundException {
        System.out.println("show方法开始");
        // 编译时异常：编译阶段报错，编译不通过
        String str = "2024-07-09 11:12:13";
        // 把字符串时间解析成 Java 中的一个日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str); // 编译时异常，提醒程序员这里的程序很容易出错，请您注意
        System.out.println(date);

        InputStream is = new FileInputStream("D:/test.jpg");

        System.out.println("show方法结束");

    }
}
