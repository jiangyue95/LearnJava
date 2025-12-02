package com.jiangyue.demo2uselock;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class UseLock {
    public static void main(String[] args) {
        // 创建一个账户类，用于创建 A，B 共同账户对象，存入 100。
        Account A = new Account(1, 100);

        // 模拟两个线程，A 和 B， A 和 B 共同操作同一个账户， A 和 B 同时取钱，每次取 10。
        new ABThread("A", A).start();
        new ABThread("B", A).start();
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Account {
    private Integer id;
    private double balance;

    public void getMoney(double balance) {
        String name = Thread.currentThread().getName();
        if (this.balance >= balance) {
            System.out.println(name + " 取钱成功，余额为：" + (this.balance - balance));
            this.balance -= balance;
            System.out.println(name + " 取钱成功，余额为：" + this.balance);
        } else {
            System.out.println(name + " 取钱失败，余额不足。余额为：" + this.balance);
        }
    }
}

class ABThread extends Thread {
    private Account account;

    public ABThread(String id, Account account) {
        super(id);
        this.account = account;
    }

    @Override
    public void run() {
        account.getMoney(100);
    }
}
