package com.jiangyue.demo4genericity;

public class GenericDemo4 {
    public static void main(String[] args) {
        // 目标：学会使用泛型方法，搞清楚作用。
        // 需求：打印任意数组的内容。
        String[] names = {"张三", "李四", "王五"};
        printArray(names);
        int[] nums = {1, 2, 3, 4, 5};
//        printArray(nums);

    }

    public static <T> void printArray(T[] names) {

    }
}
