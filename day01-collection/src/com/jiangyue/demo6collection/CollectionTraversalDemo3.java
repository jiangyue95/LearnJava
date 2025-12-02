package com.jiangyue.demo6collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTraversalDemo3 {
    public static void main(String[] args) {
        // 目标：掌握 Collection 的遍历方式一：迭代器遍历
        Collection<String> names = new ArrayList<>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");
        System.out.println(names);

        // 1. 获取迭代器对象
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            // 2. 获取元素
            String name = it.next();
            // 3. 输出元素
            System.out.println(name);
        }
    }
}
