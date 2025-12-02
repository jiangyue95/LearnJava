package com.jiangyue.demo6collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericTraversalCompareDemo7 {
    public static void main(String[] args) {
        Collection<String> items = new ArrayList<>();
        items.add("Java 入门");
        items.add("宁夏枸杞");
        items.add("黑枸杞");
        items.add("人字拖");
        items.add("特级枸杞");
        items.add("枸杞子");
        System.out.println("Original ArrayList:");
        System.out.println(items);
        Iterator<String> iterator = items.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.contains("枸杞")) {
                // 使用迭代器的 remove() 方法删除元素
                iterator.remove();
            }
        }
        System.out.println("After removing items contains “枸杞” .");
        System.out.println(items);

        Collection<String> items2 = new ArrayList<>();
        items2.add("Java 入门");
        items2.add("宁夏枸杞");
        items2.add("黑枸杞");
        items2.add("人字拖");
        items2.add("特级枸杞");
        items2.add("枸杞子");
//        System.out.println("Original ArrayList:");
//        System.out.println(items2);
//        for (String item : items2) {
//            if (item.contains("枸杞")) {
//                items2.remove(item);
//            }
//        }
//        System.out.println("After removing items contains “枸杞” .");
//        System.out.println(items2);

        Collection<String> items3 = new ArrayList<>();
        items3.add("Java 入门");
        items3.add("宁夏枸杞");
        items3.add("黑枸杞");
        items3.add("人字拖");
        items3.add("特级枸杞");
        items3.add("枸杞子");
//        System.out.println("Original ArrayList:");
//        System.out.println(items3);
//        items3.forEach(item -> {
//            if (item.contains("枸杞")) {
//                items3.remove(item);
//            }
//        });
//        System.out.println("After removing items contains “枸杞” .");
//        System.out.println(items3);

        // 使用基本的 for 循环, 一旦发生删除操作，则改变索引
        ArrayList<String> items4 = new ArrayList<>();
        items4.add("Java 入门");
        items4.add("宁夏枸杞");
        items4.add("黑枸杞");
        items4.add("人字拖");
        items4.add("特级枸杞");
        items4.add("枸杞子");
        System.out.println("Original ArrayList:");
        System.out.println(items4);
        for (int i = 0; i < items4.size(); i++) {
            String item = items4.get(i);
            if (item.contains("枸杞")) {
                items4.remove(item);
                i--;
            }
        }
        System.out.println("After removing items contains “枸杞” .");
        System.out.println(items4);

        // 使用基本 for 循环，倒序遍历
        ArrayList<String> items5 = new ArrayList<>();
        items5.add("Java 入门");
        items5.add("宁夏枸杞");
        items5.add("黑枸杞");
        items5.add("人字拖");
        items5.add("特级枸杞");
        items5.add("枸杞子");
        System.out.println("Original ArrayList:");
        System.out.println(items5);
        for (int i = items5.size() - 1; i >= 0; i--) {
            String item = items5.get(i);
            if (item.contains("枸杞")) {
                items5.remove(item);
            }
        }
        System.out.println("After removing items contains “枸杞” .");
        System.out.println(items5);
    }
}
