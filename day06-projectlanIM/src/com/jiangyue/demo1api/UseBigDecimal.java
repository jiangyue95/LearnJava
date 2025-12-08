package com.jiangyue.demo1api;

import java.math.BigDecimal;

public class UseBigDecimal {
    public static void main(String[] args) {
        // 使用浮点型运算存在结果失真问题
        // Use float type operations have result distortion problems
        useFloat();
        // 使用 BigDecimal 运算不会出现结果失真问题
        // Use BigDecimal operation will not have result distortion problems
        useBigDecimal();
    }

    public static void useFloat() {
        System.out.println(0.1 + 0.2);
        System.out.println(0.1 + 0.2 == 0.3);
        // 使用 0.1f 的形式存在四舍五入所以结果为 true
        // Using 0.1f form exists rounding so the result is true
        System.out.println(0.1f + 0.2f == 0.3f);
    }

    public static void useBigDecimal() {
        // 使用 BigDecimal 运算不会出现结果失真问题
        // Use BigDecimal operation will not have result distortion problems
        // 1、把小数包装成 BigDecimal 对象
        // 1、Wrap the decimal into a BigDecimal object
        // 必须使用 public BigDecimal(String val) 构造方法
        // Must use the public BigDecimal(String val) constructor
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")));
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")).equals(new BigDecimal("0.3")));
        // 优化方案，可以直接调用 valueOf 方法，内部使用的就是 public BigDecimal(String val) 构造方法
        // Optimization solution, you can call the valueOf method,
        // which internally uses the public BigDecimal(String val) constructor
        BigDecimal b1 = BigDecimal.valueOf(0.1);
        BigDecimal b2 = BigDecimal.valueOf(0.2);
        BigDecimal c1 = b1.add(b2);
        // 最后还需要转换成 Double 类型
        // Finally, you need to convert to Double type
        double result = c1.doubleValue();
        System.out.println(result);

        // 在除法中存在问题
        // In the division, there is a problem
        BigDecimal i = BigDecimal.valueOf(0.1);
        BigDecimal j = BigDecimal.valueOf(0.3);
        // 如果不加后两个参数，则会抛出异常
        // If you don't add the last two parameters, an exception will be thrown
        BigDecimal k = i.divide(j, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(k);
    }
}
