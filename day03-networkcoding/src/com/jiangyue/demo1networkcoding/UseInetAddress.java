package com.jiangyue.demo1networkcoding;

import java.net.InetAddress;

public class UseInetAddress {
    public static void main(String[] args) {
        try {
            // 获取本地 IP
            System.out.println(InetAddress.getLocalHost().getHostAddress());
            System.out.println("主机名：" + InetAddress.getLocalHost().getHostName());
            // 获取对方 IP
            System.out.println(InetAddress.getByName("www.google.com").getHostAddress());
            System.out.println("主机名：" + InetAddress.getByName("www.google.com").getHostName());

            //判断本机与对方主机是否互通，判断是否联网
            System.out.println(InetAddress.getByName("www.baidu.com").isReachable(5000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
