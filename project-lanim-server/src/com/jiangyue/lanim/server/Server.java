package com.jiangyue.lanim.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    // 定义一个集合容器存储所有登录进来的客户端管道，以便将来群发消息给他们。
    // 定义一个 Map 集合，键是存储客户端的管道，值是这个管道的用户名称
    public static final Map<Socket, String> onlineSockets = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("LanIM server starts ...");
        try {
            // 1. register port
            ServerSocket serverSocket = new ServerSocket(Constant.port);
            // 2. main thread is in charge of receiving connecting requests from client
            while (true) {
                // 3. Call accept() to get the Socket object from client
                System.out.println("Waiting client connection ...");
                Socket socket = serverSocket.accept();
                // 把这个管道交给一个独立的线程来处理，以便支持很多客户端可以同时进来通信。
                // Use an independent thread handle the socket,
                new ServerReaderThread(socket).start();
                System.out.println("1 Client connected.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
