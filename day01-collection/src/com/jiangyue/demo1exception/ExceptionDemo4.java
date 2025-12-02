package com.jiangyue.demo1exception;

public class ExceptionDemo4 {
    public static void main(String[] args) {
        // 目的：认识自定义异常
        try {
            saveAge(300);
        } catch (JYAgeIllegalException e) {
            throw new RuntimeException(e);
        }
    }

    // 需求：我们公司的系统只要收到了年龄小于1或者大于200岁就是一个年龄非法异常
    public static void saveAge(int age) throws JYAgeIllegalException {
        if (age < 1 || age > 200) {
            // 年龄非法：抛出一个异常返回
            throw new JYAgeIllegalRuntimeException("年龄非法 age 不能低于1岁不能高于200岁");
        } else {
            System.out.println("年龄合法");
            System.out.println("保存年龄：" + age);
        }
    }
}
