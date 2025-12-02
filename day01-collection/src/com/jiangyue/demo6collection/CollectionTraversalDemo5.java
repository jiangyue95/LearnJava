package com.jiangyue.demo6collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class CollectionTraversalDemo5 {
    public static void main(String[] args) {
        // 目标：掌握 Collection 的遍历方式三：Lambda 表达式
        Collection<String> names = new ArrayList<>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");

        // 匿名内部类
        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // Lambda 表达式
        names.forEach(name -> System.out.println(name));
        // 方法引用
        names.forEach(System.out::println);
    }
}
