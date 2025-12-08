package com.jiangyue.demo1api;

import java.time.LocalDateTime;

public class UseStringBuilder {
    public static void main(String[] args) {
        // 目标：高效拼接字符串
        // Goal: Efficiently concatenate strings
        // 检查传统的方法
        // Check traditional method
        testOriginalMethod();
        // 使用 StringBuilder
        testStringBuilder();
    }

    public static void testStringBuilder() {
        // 定义字符串可以使用 String 类型，但是操作字符串建议使用 StringBuilder，性能更好
        // Define strings can use String type, but it is recommended to use StringBuilder, performance is better
        LocalDateTime start = LocalDateTime.now();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append("abc");
        }
        LocalDateTime end = LocalDateTime.now();
        int time = end.getNano() - start.getNano();
        System.out.println("StringBuilder method spent " + time / 1000000 + " ms.");
    }

    public static void testOriginalMethod() {
        // 使用 + 拼接字符串性能很差
        // Use + to concatenate strings is very slow
        LocalDateTime start = LocalDateTime.now();
        String s = "";
        for (int i = 0; i < 1000000; i++) {
            s += "abc";
        }
        LocalDateTime end = LocalDateTime.now();
        int time = end.getNano() - start.getNano();
        System.out.println("Original method spent " + time / 1000000 + " ms.");
    }
}
