package com.jiangyue.demo11stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStream {
    public static void main(String[] args){
        useEnd();
        getDouble();
        List<String> list = List.of("张三丰", "张三", "流水", "Nolan");
        System.out.println(list);

        // 传统方案找出姓张的三个字的人
        List<String> newList = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张")&&name.length()==3) {
                newList.add(name);
            }
        }
        System.out.println(newList);

        // stream流
        System.out.println("使用 stream 流：");
        list.stream().filter(s->s.startsWith("张"))
                .filter(s->s.length()==3)
                .forEach(System.out::println);

        // stream 流收集传回对象
        System.out.println("使用 stream 流收集传回对象：");
        List<String> newList2 = list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).collect(Collectors.toList());
        System.out.println(newList2);
    }

    public static void getStreams() {
        // 获取 Stream 流
        // 1、集合 stream 流，所有单列结合获取 Stream 流都要调用 stream 方法
        Collection<String> list = new ArrayList<>();
        Stream<String> listStream = list.stream();

        // 2、Map 集合获取 Stream 流，获取键流，值流，键值对流
        Map<String, String> map = new HashMap<>();
        Stream<String> valueStream = map.values().stream(); // 值流
        Stream<String> keyStream = map.keySet().stream(); // 键流
        Stream<Map.Entry<String, String>> entryStream = map.entrySet().stream(); // 键值对流

        // 3、获取数组的流
        String[] strs = {"张三", "王五", "赵六"};
        Stream<String> stream = Arrays.stream(strs);
        Stream<String> stream1 = Stream.of(strs);
        Stream<String> stream2 = Stream.of("张三", "王五", "赵六"); // 等价于 Stream.of(strs)
    }

    public static void getDouble() {
        List<Double> list = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5, 5.5, 6.6, 7.7, 8.8, 9.9, 10.1);
        // 默认升序，去重
        list.stream().sorted().distinct().forEach(System.out::println);
        System.out.println("==========");
        // 只需要最大的两个元素
        list.stream().sorted(Comparator.reverseOrder()).distinct().limit(2).forEach(System.out::println);
        System.out.println("==========");
        // 跳过前面两个元素
        list.stream().skip(2).forEach(System.out::println);
        System.out.println("==========");
        // 加工方法
        list.stream().map(s->"加十分后："+ (s + 10)).forEach(System.out::println);
        System.out.println("==========");
        // 合并流
        Stream<Double> stream1 = Stream.of(1.1, 2.2, 3.3);
        // 统计合并流之后的长度
        System.out.println(Stream.concat(list.stream(), stream1).count());
    }

    public static void useEnd() {
        Stream<Double> stream1 = Stream.of(1.1, 2.2, 3.3);
        Stream<Double> stream2 = Stream.of(4.4, 5.5, 6.6);
        Optional<Double> max = Stream.concat(stream1, stream2).max(Comparator.comparing(s -> s));
        System.out.println(max);
    }
}
