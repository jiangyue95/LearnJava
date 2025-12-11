package com.jiangyue.lanim.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class ServerReaderThread extends Thread {
    private Socket socket;

    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while(true) {
            try {
//                System.out.println("Client connected.");
                // 接收的消息可能有很多种类型：
                // 1、登录消息（包含昵称）
                // 2、群聊消息
                // 3、私聊消息
                // 4、退出消息
                // 所以客户端必须声明协议发送消息
                // 比如客户端先发1，代表登录消息
                // 比如客户端先发2，代表群聊消息
                // 比如客户端先发3，代表私聊消息
                // 比如客户端先发4，代表退出消息
                // 先从 socket 管道中接收客户端发送来的消息类型编号
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                int type = dis.readInt();
                switch (type) {
                    case 1:
                        // 客户端发来了登录消息，接下来要接收昵称数据，再更新全部在线客户端的在线人数列表
                        String nickname = dis.readUTF();
                        // 把这个登录成功的客户端 socket 存入到在线集合
                        Server.onlineSockets.put(socket, nickname);
                        // 更新全部客户端的在线人数列表
                        updateSocketOnLineList();
                        break;
                    case 2:
                        // 群聊消息, 接收消息内容，然后把消息发送给所有在线客户端
                        String msg = dis.readUTF();
                        senMsgToALL(msg);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Client disconnected."); // command line notice
                Server.onlineSockets.remove(socket); // when the user is offline, remove it from online list.
                updateSocketOnLineList(); // When user is offline, update the online list again.
                break;
            }
        }
    }

    // 给全部在线 socket 推送当前客户端发来的消息
    private void senMsgToALL(String msg) {
        // 一定要拼装好这个消息再发送给全部 socket
        StringBuilder sb = new StringBuilder();
        String name = Server.onlineSockets.get(socket);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EEE a");
        String nowStr = dtf.format(now);

        String mesgResult = sb.append(name)
                .append(" ")
                .append(nowStr)
                .append("\r\n")
                .append(msg)
                .append("\r\n")
                .toString();
        // 推送给全部在线的 socket
        for (Socket socket : Server.onlineSockets.keySet()){
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeInt(2); // 2 代表群聊信息
                dos.writeUTF(mesgResult);
                dos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updateSocketOnLineList() {
        // 更新全部客户端的在线人数列表
        // 拿到全部在线客户端的用户名称，把这些名称转发给全部在线 socket 管道
        // 1、拿到当前全部在线用户的名称
        Collection<String> onLineUsers = Server.onlineSockets.values();
        // 2、把这个集合中的所用用户全部推送给全部在线 socket 管道
        for (Socket socket : Server.onlineSockets.keySet()) {
            try {
                // 3、把集合中的所有用户名称，通过 socket 管道发送给客户端
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeInt(1); // 1 代表登录信息
                dos.writeInt(onLineUsers.size()); // 告诉客户端，接下来要发送多少个用户名称
                for (String onLineUser : onLineUsers) {
                    dos.writeUTF(onLineUser);
                }
                dos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
