package com.jiangyue.demo2udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPCM {
    public static void main(String[] args) throws Exception {
        System.out.println("UDP Client starts");
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的数据：");
            String str = sc.nextLine();
            if ("exit".equals(str)) {
                System.out.println("客户端退出");
                ds.close(); // 管道关闭，释放资源
                break;
            }
            byte[] data = str.getBytes();
            ds.send(
                    new DatagramPacket(
                            data,
                            data.length,
                            InetAddress.getLocalHost(),
                            8888)
            );
        }
    }
}
