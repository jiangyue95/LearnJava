package com.jiangyue.demo7list;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ListDemo1 {
    public static void main(String[] args) {
        // 目标：掌握 List 系列集合独有的功能。
        List<String> names = new ArrayList<>();

        // 添加数据
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");
        System.out.println(names);

        // 给第三个位置插入一个数据: 姜超
        names.add(2, "姜超");
        System.out.println(names);

        // 删除第三个位置的数据
        names.remove(2);
        System.out.println(names);

        // 把王五修改成：金毛
        names.set(2, "金毛");
        System.out.println(names);

        // 获取张三
        System.out.println(names.get(0));

        // for 循环遍历
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        // 增强 for 循环遍历
        for (String name : names) {
            System.out.println(name);
        }

        // 迭代器遍历
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
