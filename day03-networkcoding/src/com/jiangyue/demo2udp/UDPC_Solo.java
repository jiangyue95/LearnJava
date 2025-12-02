package com.jiangyue.demo2udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPC_Solo {
    // 创建客户端
    public static void main(String[] args) throws Exception {
        System.out.println("客户端已启动");
        // 创建发送端对象，实现单发单收
        DatagramSocket dgs = new DatagramSocket();
        // 创建数据包对象封装要发送的数据
        byte[] b = "Hello, here is a UDPClient message!".getBytes();
        /*
        * 参数一：数据
        * 参数二：数据长度
        * 参数三：发送数据的目的IP
        * 参数四：发送数据目的端口
         */
        DatagramPacket packet = new DatagramPacket(
                b,
                b.length,
                InetAddress.getByName("localhost"),
                8888
        );
        while ( true) {
            dgs.send(packet);
        }
    }
}
