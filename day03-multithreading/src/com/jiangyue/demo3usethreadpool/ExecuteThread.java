package com.jiangyue.demo3usethreadpool;

import java.util.concurrent.*;

public class ExecuteThread {
    public static void main(String[] args) {
        // 创建线程池对象，使用线程池的实现类
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                10,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        // 使用线程池执行 Runnable 任务
        Runnable task1 = new RunnableTask1();
        executorService.execute(task1); // 任务可以复用，第一个任务
        executorService.execute(task1);
        executorService.execute(task1); // 复用线程
        executorService.execute(task1);
        executorService.execute(task1);

        // 使用线程池执行 Callable 任务
        Future<String> f1 = executorService.submit(new CallableTask(100));
        Future<String> f2 = executorService.submit(new CallableTask(200));
        Future<String> f3 = executorService.submit(new CallableTask(300));
        Future<String> f4 = executorService.submit(new CallableTask(400));
        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 一般不关闭线程池，可以一直使用，但是需要调用 shutdown() 方法
//        executorService.shutdown(); // 等所有任务执行完毕后关闭线程池
//        executorService.shutdownNow(); // 立即关闭线程池，并打断正在执行的任务

        // 当核心线程都在忙时，临时创建新线程
        executorService.execute(task1); // 临时线程，第6个为临时线程

        // 任务拒绝策略
        executorService.execute(task1); // 拒绝策略，直接抛出日常
    }
}

class RunnableTask1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CallableTask implements Callable<String> {
    private int num;

    public CallableTask(int num) {
        this.num = num;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += i;
        }
        return Thread.currentThread().getName() + ":" + sum;
    }
}