package com.jiangyue.demo1multithreading;

public class MultiThreading2 {
    public static void main(String[] args) {
        // 创建线程任务对象代表一个线程任务
        Runnable r = new MyRunnable();
        // 把线程任务对象交给一个线程对象来处理
        Thread t = new Thread(r);
        // 启动线程
        t.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("Main threading is running: " + i);
        }

        // 匿名内部类实现
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("MyThread is running: " + i);
                }
            }
        }).start();

        // 函数式接口匿名类
        new Thread(() -> {for (int i = 0; i < 5; i++) System.out.println("MyThread is running: " + i);}).start();
    }
}

// 定义一个线程任务类实现 Runnable 接口
class MyRunnable implements Runnable {
    // 重写 run 方法，设置线程任务
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread is running: " + i);
        }
    }
}
