package com.jiangyue.demo3tcp;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

// 多发多收
public class TCPCM {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 8888);
        System.out.println("Client starts");
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please input data");
            String msg = sc.nextLine();
            dos.writeUTF(msg);
            dos.flush();
            if ("exit".equals(msg)) {
                System.out.println("Client exit");
                dos.close();
                s.close();
                break;
            }
        }
    }
}
