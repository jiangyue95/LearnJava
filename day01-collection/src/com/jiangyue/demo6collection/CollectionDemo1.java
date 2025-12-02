package com.jiangyue.demo6collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionDemo1 {
    public static void main(String[] args) {
        // 目标：搞清楚 Collection 集合的整体特点。
        // 1. List 家族的集合：有序、可重复、有索引。
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list); // [hello, world, java] 顺序和添加顺序一致
        String rs = list.get(0);
        System.out.println(rs);

        // 2. Set 家族的集合：无序、不可重复、无索引。
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.add("java");
        set.add("Python");
        System.out.println(set);
        System.out.println(set);
    }
}
