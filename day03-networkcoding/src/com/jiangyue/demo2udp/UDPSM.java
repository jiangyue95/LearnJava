package com.jiangyue.demo2udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPSM {
    public static void main(String[] args) throws Exception {
        System.out.println("UDP Server starts");
        DatagramSocket ds = new DatagramSocket(8888);
        byte[] b = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b, b.length);
        while (true) {
            System.out.println("Waiting for data...");
            ds.receive(dp);
            // show message
            System.out.println("Received: " + new String(b, 0, dp.getLength()));
            // get IP and port
            System.out.println("From: " + dp.getAddress().getHostAddress() + ":" + dp.getPort());
        }

    }
}
