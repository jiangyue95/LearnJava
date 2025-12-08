package com.jiangyue.demo1dynamicproxy;

public class Main {
    public static void main(String[] args) {
        User user = new User("Tom", "123456", "Tom@gmail.com");
        // Create proxy object
        UserMapper proxy = UserProxy.getInstance(user);
        System.out.println(proxy.add(user));
        proxy.delete("Tom@gmail.com");
        proxy.update(user);
    }
}
