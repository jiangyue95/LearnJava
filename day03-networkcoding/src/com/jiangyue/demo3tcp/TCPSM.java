package com.jiangyue.demo3tcp;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSM {
    public static void main(String[] args) throws Exception{
        System.out.println("TCP Server starts");
        ServerSocket ss = new ServerSocket(8888);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        while (true) {
            try {
                String msg = dis.readUTF();
                if ("exit".equals(msg)) {
                    System.out.println("Server quits");
                    dis.close();
                    s.close();
                    break;
                }
                System.out.println("Client:" + msg);
                System.out.println("Client:" + InetAddress.getLocalHost().getHostAddress());
            } catch (Exception e) {
                System.out.println("Client disconnected");
                break;
            }
        }
    }
}
