package com.jiangyue.demo2uselock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UseSyncLock {
    public static void main(String[] args) {
        AccountUseLock B = new AccountUseLock(1, 200);
        new ABThreadUseLock("A", B).start();
        new ABThreadUseLock("B", B).start();

        AccountUseLock C = new AccountUseLock(2, 200);
        new ABThreadUseLock("C", C).start();
        new ABThreadUseLock("D", C).start();
    }
}

class Accounts extends Account {
    public Accounts(Integer id, double balance) {
        super(id, balance);
    }
    private double p = super.getBalance();

//    @Override
    public void getMoney1(double amount) {
        String name = Thread.currentThread().getName();
//        synchronized ("hei"){
        // 同步锁只能为一个唯一对象，这里使用字符串，字符串是内存内只能加载一份，所以可以作为锁。
        // 同步锁只能为一个对象，这里使用 this，this 为当前对象，不用像字符串一样，每次锁的时候影响到其他对象
        synchronized (this) {
            if (p >= amount) {
                System.out.println(name + "当前余额为：" + p);
                p -= amount;
                System.out.println(name + "取钱成功，余额为：" + p);
            } else {
                System.out.println(name + "取钱失败，余额不足。余额为：" + p);
            }
        } // 锁对象：对于实例方法用 this 作为锁，对于静态方法用 类名.class 作为锁
    }

    @Override
    public synchronized void getMoney(double amount) {
        System.out.println("getMoney");
        String name = Thread.currentThread().getName();
        if (p >= amount) {
            System.out.println(name + "当前余额为：" + p);
            p -= amount;
            System.out.println(name + "取钱成功，余额为：" + p);
        } else {
            System.out.println(name + "取钱失败，余额不足。余额为：" + p);
        }
    }
}

//class Accounts extends Account {
//    public Accounts(Integer i, double balance) {
//        super(id, balance);
//    }
//    private double p = super.getBalance();
//
//    @Override
//    public synchronized void getMoney(double amount) {
//        String name = Thread.currentThread().getName();
//        if (p >= amount) {
//            System.out.println(name + "当前余额为：" + p);
//            p -= amount;
//            System.out.println(name + "取钱成功，余额为：" + p);
//        } else {
//            System.out.println(name + "取钱失败，余额不足。余额为：" + p);
//        }
//    }
//}

class AccountUseLock {
    private Integer id;
    private double balance;
    private final Lock lock = new ReentrantLock();  // 一个账户一把锁，加 final 表示不能修改
    // 创建一个锁对象，不能为静态，静态的话所有对象都用一把锁
    public AccountUseLock(Integer id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void getMoney(double amount) {
        String name = Thread.currentThread().getName();
        lock.lock(); // 加锁
        try {
            if (balance >= amount) {
                System.out.println(name + "当前余额为：" + balance);
                balance -= amount;
                System.out.println(name + "取钱成功，余额为：" + balance);
            } else {
                System.out.println(name + "取钱失败，余额不足。余额为：" + balance);
            }
        } finally {
            lock.unlock(); // 解锁需要放在 finally 中，否则可能会造成死锁
        }
    }
}

class ABThreadUseLock extends Thread {
    private AccountUseLock account;

    public ABThreadUseLock(String id, AccountUseLock account) {
        super(id);
        this.account = account;
    }

    @Override
    public void run() {
        account.getMoney(100);
    }
}