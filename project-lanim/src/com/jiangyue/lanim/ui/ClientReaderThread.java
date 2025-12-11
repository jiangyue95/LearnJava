package com.jiangyue.lanim.ui;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClientReaderThread extends Thread {
    private Socket socket;
    private DataInputStream dis;
    private MainChatFrame mainChatFrame;

    public ClientReaderThread(Socket socket, MainChatFrame mainChatFrame) {
        this.socket = socket;
        this.mainChatFrame = mainChatFrame;
    }

    @Override
    public void run() {
        while(true) {
            try {
                // 接收的消息可能有很多种类型：
                // 1、在线人数更新的数据（包含昵称）
                // 2、群聊消息
                // 3、私聊消息（to do）
                // 先从 socket 管道中接收客户端发送来的消息类型编号
                dis = new DataInputStream(socket.getInputStream());
                int type = dis.readInt();
                switch (type) {
                    case 1:
                        // 客户端发来了登录消息，接下来要接收昵称数据，再更新全部在线客户端的在线人数列表
                        updateClientOnLineList();
                        break;
                    case 2:
                        // 服务端发来的群聊消息，接收消息内容，然后把消息显示在聊天窗口中
                        getMsgToWin();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void getMsgToWin() throws IOException {
        // 获取群消息
        String msg = dis.readUTF();
        mainChatFrame.setMsgToWin(msg);
    }

    private void updateClientOnLineList() throws IOException {
        // 1、读取有多少个在线用户
        int count = dis.readInt();
        // 2、循环控制读取多少个用户信息
        String[] onLineUsers = new String[count];
        for (int i = 0; i < count; i++) {
            String nickname = dis.readUTF();
            onLineUsers[i] = nickname;
        }
        // 3、更新到窗口界面右侧的列表中
        mainChatFrame.updateOnLineUserList(onLineUsers);
    }
}
