package com.jiangyue.demo1multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MultiThreading3 {
    public static void main(String[] args) {
        // 创建一个 callable 接口的实现类对象
        MyCallable c = new MyCallable(100);

        // 把 callable 接口的实现类对象，封装成线程任务对象 FutureTask 对象
        // FutureTask 类实现了 Runnable 接口，所以可以作为线程任务对象
        // 线程任务对象可以作为线程对象来启动，可以获取线程执行完毕后的结果
        Runnable t = new FutureTask<Integer>(c);

        // 把 FutureTask 对象交给一个线程对象来处理
        Thread thread = new Thread(t);
        thread.start();

        // 调用 FutureTask 对象的 get() 方法获取线程执行完毕后的结果
        try {
            System.out.println(thread.getName() + " is running: " + ((FutureTask<Integer>) t).get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// 定义实现类，实现 callable 接口
class MyCallable implements Callable<Integer> {
    private int sum;

    public MyCallable(int sum) {
        this.sum = sum;
    }

    // 重写 call 方法，返回计算结果
    @Override
    public Integer call() throws Exception {
        int n = 0;
        for (int i = 0; i < sum; i++) {
            n += i;
        }
        return n;
    }
}
