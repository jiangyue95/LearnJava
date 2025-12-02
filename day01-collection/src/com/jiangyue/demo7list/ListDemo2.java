package com.jiangyue.demo7list;

import java.util.LinkedList;

public class ListDemo2 {
    public static void main(String[] args) {
        // 目标：用 LinkedList 做一个队列对象
        // 1. 创建 LinkedList 对象
        LinkedList<String> queue = new LinkedList<>();
        // 2. 添加元素
        queue.addLast("a");
        queue.addLast("b");
        queue.addLast("c");
        // 3. 打印队列
        System.out.println(queue);
        // 4. 取出元素
        String first = queue.removeFirst();
        System.out.println(first);
        System.out.println(queue);

        // 目标：用 LinkedList 做一个栈对象
        // 1. 创建 LinkedList 对象
        LinkedList<String> stack = new LinkedList<>();
        // 2. 添加元素
        stack.push("a");
        stack.push("b");
        stack.push("c");
        // 3. 打印栈
        System.out.println(stack);
        // 4. 取出元素
        String last = stack.pop();
        System.out.println(last);
        System.out.println(stack);
    }
}
