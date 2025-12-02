package com.jiangyue.demo1exception;

import java.util.Scanner;

public class ExceptionDemo6 {
    public static void main(String[] args) {
        // 目标：掌握异常的处理方法2: 捕获异常对象，尝试重新修复
        System.out.println("程序开始...");
        while (true) {
            try {
                double price = userInputPrice();
                System.out.println("价格：" + price);
                break;
            } catch (Exception e) {
                System.out.println("价格输入有误，请重新输入：");
            }
        }
    }

    public static double userInputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入商品价格：");
        double price = sc.nextDouble();
        return price;
    }
}
