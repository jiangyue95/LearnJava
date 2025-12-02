package com.jiangyue.demo10map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class MyMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "张三");
        map.put(2, "李四");
        map.put(3, "王五");
        System.out.println(map);
        // 遍历方式一：键找值
        System.out.println("遍历方式一：键找值");
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }
        // 遍历方式二：键值对
        System.out.println("遍历方式二：键值对");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }
        // 一步到位
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry);
        }
        // 遍历方式三：Lambda 表达式
        System.out.println("遍历方式三：Lambda 表达式");
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println(integer + "=" + s);
            }
        });
        // 函数式接口的匿名内部类
        map.forEach((key, value) -> System.out.println(key + "=" + value));
    }
}
