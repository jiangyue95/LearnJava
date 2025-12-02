package com.jiangyue.demo3tcp;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

// Client 单条发送
public class TCPC {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 8888);
        System.out.println("Client starts");
        // 从 Socket 通信管道中得到一个字节输出流，那么对面服务端也要是一个对应的字节输入流
        OutputStream os = s.getOutputStream();
        // 特殊数据流
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(100);
        dos.writeUTF("Hello World, I am client.");
        // 关闭管道
        dos.close();
    }
}
