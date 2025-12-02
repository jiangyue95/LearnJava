package com.jiangyue.demo3tcp;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ServerReader extends Thread {
    private Socket s;
    public ServerReader(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                try {
                    String msg = dis.readUTF();
                    if ("exit".equals(msg)) {
                        System.out.println("Server exits");
                        dis.close();
                        is.close();
                        return;
                    }
                    System.out.println("Client: " + msg);
                    System.out.println(
                            "Client info: "
                                    + s.getInetAddress().getHostAddress()
                                    + ":"
                                    + s.getPort()
                    );
                } catch (Exception e) {
                    System.out.println(
                            "Client: "
                                    + s.getInetAddress().getHostAddress()
                                    + "disconnected"
                    );
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
