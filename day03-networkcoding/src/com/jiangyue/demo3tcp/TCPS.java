package com.jiangyue.demo3tcp;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;

public class TCPS {
    public static void main(String[] args) throws Exception {
        System.out.println("TCP Server starts");
        ServerSocket ss = new ServerSocket(8888);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        DataInputStream dis  = new DataInputStream(is);
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println("客户端IP：" + s.getInetAddress().getHostAddress() + ":" + s.getPort());
    }
}
