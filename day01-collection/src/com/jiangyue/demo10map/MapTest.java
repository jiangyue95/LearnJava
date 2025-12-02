package com.jiangyue.demo10map;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        List<String> location = new ArrayList<>();
        String[] loact = {"北京", "上海", "广州", "深圳"};
        Random random = new Random();
        for (int i = 0; i < 80; i++) {
            int index = random.nextInt(loact.length);
            location.add(loact[index]);
        }
//        System.out.println(location);
        // 最终统计为键值对集合
        Map<String, Integer> map = new HashMap<>();
        for (String str : location) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        map.forEach((k, v) -> System.out.println(k + ":" + v));

        // 选出最多的城市
        // 将 HashMap 转换为 Collection 类对象
        Collection<Map.Entry<String, Integer>> col = map.entrySet();
        // 创建 Collection 类对象 col 的迭代器
        Iterator<Map.Entry<String, Integer>> iterator = col.iterator();
        // 遍历迭代器
        while (iterator.hasNext()) {
            // 获取元素
            Map.Entry<String, Integer> entry = iterator.next();
            // 比较元素的值是否等于map 值中的最大值
            if (entry.getValue() == Collections.max(map.values())) {
                // 如果相等，则输出键，即城市名称
                System.out.println("投票最多的城市是：" + entry.getKey());
            }
        }
    }
}
