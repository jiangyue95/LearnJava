package com.jiangyue.demo3tcp;

import java.net.ServerSocket;
import java.net.Socket;

// Multi Server using Threadings
public class TCPSMT {
    public static void main(String[] args) throws Exception {
        System.out.println("TCP Server with threading starts");
        ServerSocket ss = new ServerSocket(8888);
        while (true) {
            Socket s = ss.accept();
            System.out.println("Client connected: "+ s.getInetAddress().getHostAddress());
            new ServerReader(s).start();
        }
    }
}
