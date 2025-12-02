package com.jiangyue.demo2genericity;

public class GenericDemo2 {
    public static void main(String[] args) {
        // 目标：学会自定义泛型类
        // 需求：请你模拟 ArrayList 集合自定义一个集合 MyArrayList
        // MyArrayList<String> myArrayList = new MyArrayList<>();
        MyArrayList<String> myArrayList = new MyArrayList<>(); // JDK 7 开始支持后面尖括号 不写类型
        myArrayList.add("hello");
        myArrayList.add("world");
//        myArrayList.add(1); // 泛型类型为 String，不能添加非 String 类型的数据
        myArrayList.add("java");
        System.out.println(myArrayList.remove("hello"));
        System.out.println(myArrayList);

    }
}
