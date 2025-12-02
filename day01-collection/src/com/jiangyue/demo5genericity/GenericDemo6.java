package com.jiangyue.demo5genericity;


import java.util.ArrayList;

public class GenericDemo6 {
    public static void main(String[] args) {
        // 目标：搞清楚泛型和集合不支持基本数据类型，只能支持引用数据类型
//        ArrayList<int> list = new ArrayList<>();
        // 泛型擦除：泛型工作在编译极端，等编译后泛型就没用了，所以泛型在编译后都会被擦除。所有类型都会回复成 Object 对象。
        // 把基本数据类型标称包装类对象。
        // 手工包装
        Integer it = Integer.valueOf(100);

        // 自动装箱：基本数据类型的数据可以直接编程包装对象的数据，不需要额外做任何事情
        Integer it11 = 130;
        Integer it22 = 130;
        System.out.println(it11 == it22);

        // 自动拆箱：把包装类型的对象直接给基本类型的数据
        int i = it11;
        System.out.println(i);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(130); // 自动装箱
        list.add(120); // 自动装箱

        int rs = list.get(1); // 自动拆箱
        
    }
}
