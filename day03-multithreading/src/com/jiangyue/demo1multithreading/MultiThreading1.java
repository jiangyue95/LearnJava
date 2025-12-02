package com.jiangyue.demo1multithreading;

public class MultiThreading1 {
    // main 方法本身是由一条主线程负责执行的
    public static void main(String[] args) {
        MyThread t = new MyThread(); // 创建一个线程对象
        t.start(); // 启动线程，向 CPU 注册请求开启一个线程
        // t 线程执行，在主线程外执行，必须在 t.start() 后面才能开启 t 线程
        for (int i = 0; i < 5; i++) {
            System.out.println("main is running: " + i);
        }
    }
}

// 定义一个子类继承 Thread 类，成为一个线程类
class MyThread extends Thread {
    // 重写 Thread 类的 run 方法，线程执行体
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread is running: " + i);
        }
        // 在 run 方法中编写线程的任务代码（线程的任务）
    }
}