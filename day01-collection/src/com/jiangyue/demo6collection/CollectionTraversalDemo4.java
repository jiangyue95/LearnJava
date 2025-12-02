package com.jiangyue.demo6collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTraversalDemo4 {
    // 目标：掌握 Collection 的遍历方式二：增强 for
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");

        // 集合
        for (String name : names) {
            System.out.println(name);
        }

        // 数组
        String[] names2 = { "张三", "李四", "王五", "赵六" };
        for (String name : names2) {
            System.out.println(name);
        }
    }
}
