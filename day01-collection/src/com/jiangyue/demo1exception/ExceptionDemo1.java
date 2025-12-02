package com.jiangyue.demo1exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo1 {
    public static void main(String[] args) {
//        show();
        try {
            // 监视代码，出现异常，会被 catch 拦截住这个异常
            show2();
        } catch (ParseException e) {
            e.printStackTrace(); // 打印异常信息
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void show2() throws ParseException, FileNotFoundException {
        System.out.println("show2方法开始");
        // 编译时异常：编译阶段报错，编译不通过
        String str = "2024-07-09 11:12:13";
        // 把字符串时间解析成 Java 中的一个日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str); // 编译时异常，提醒程序员这里的程序很容易出错，请您注意
        System.out.println(date);

        InputStream is = new FileInputStream("D:/test.jpg");

        System.out.println("show2方法结束");

    }

    public static void show() {
        // 运行时异常
        int[] arr = {1, 2, 3};
        //
//        System.out.println(arr[3]);
        //
//        System.out.println(10/0);
        // 空指针异常
        String str = null;
        System.out.println(str); // 可以正常打印出 null
        System.out.println(str.length()); // NullPointerException

        // 不会执行
        System.out.println("show方法结束");
    }

}
