package com.jiangyue.demo2genericity;

import java.util.ArrayList;

public class GenericDemo1 {
    public static void main(String[] args) {
        // 目的：认识泛型，搞清楚使用泛型的好处
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
//        list.add(23);
//        list.add(9.9);
//        list.add(true);
//        list.add('a');
//        list.add(new Object());

        // 获取数据
        for (int i = 0; i < list.size(); i++) {
            String rs = list.get(i);
            System.out.println(rs);
        }
    }
}
