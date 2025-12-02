package com.jiangyue.demo2udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPS_Solo {
    // 这里是服务端
    public static void main(String[] args) throws Exception {
        System.out.println("服务端已启动");
        // 创建接收端对象，注册端口
        DatagramSocket ds = new DatagramSocket(8888);
        // 创建数据包对象负责接收数据
        byte[] b = new byte[1024*64];
        DatagramPacket dp = new DatagramPacket(b, b.length);
        while (true) {
            ds.receive(dp);
            System.out.println("服务端接收到的数据：" + new String(dp.getData(), 0, dp.getLength()));
            // 获取对方 IP 对象和端口号
            System.out.println(
                    "对方 IP："
                            + dp.getAddress().getHostAddress()
                            + " 对象端口："
                            + dp.getPort()
            );
        }
    }
}
