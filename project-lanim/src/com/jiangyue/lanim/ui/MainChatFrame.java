package com.jiangyue.lanim.ui;

import javax.swing.*;
import java.awt.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class MainChatFrame extends JFrame {
    private JTextArea chatArea; // message area
    private JTextArea inputArea; // input area
    private JButton sendBtn;  // send button
    private JList<String> onLineUserList;  // users list
    private Socket socket;

    public MainChatFrame() {
        initView();
        this.setVisible(true);
    }

    public MainChatFrame(String nickname, Socket socket) {
        this(); // 调用上方的无参构造器，初始化界面信息
        // 初始化数据
        this.setTitle("LanIM - " + nickname + " - " + "Group Chat");
        this.socket = socket;

        // 立即把客户端的这个 socket 管道交给一个独立的线程负责读取 客户端 socket 从服务器收到的在线人数更新数据或者群聊数据
        new ClientReaderThread(socket, this).start();
    }

    private void initView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        // left area: chat area and input area
        JPanel leftPanel = new JPanel(new BorderLayout(5, 5));

        // message area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        leftPanel.add(chatScrollPane, BorderLayout.CENTER);

        // input area
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputArea = new JTextArea(3, 20);
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        JScrollPane inputScrollPane = new JScrollPane(inputArea);
        inputPanel.add(inputScrollPane, BorderLayout.CENTER);

        // send button
        sendBtn = new JButton("Send");
        inputPanel.add(sendBtn, BorderLayout.EAST);
        leftPanel.add(inputPanel, BorderLayout.SOUTH);

        // 给发送按钮绑定事件
        sendBtn.addActionListener(e -> {
            String msg = inputArea.getText();
            inputArea.setText(""); // 清空输入框
            try {
                senMsgToServer(msg);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // right area: users list
        onLineUserList = new JList<>();
        JScrollPane userScroll =  new JScrollPane(onLineUserList);
        userScroll.setPreferredSize(new Dimension(200, 0));

        // split into two panels
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, userScroll);
        splitPane.setResizeWeight(0.8);
        splitPane.setDividerSize(5);
        splitPane.setOneTouchExpandable(true);
        setContentPane(splitPane);
    }

    private void senMsgToServer(String msg) throws IOException {
        // 发送群聊消息给服务器
        // 创建 DataOutputStream 对象
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeInt(2);
        dos.writeUTF(msg);
        dos.flush();
    }

    public static void main(String[] args) {
        new MainChatFrame();
    }

    public void updateOnLineUserList(String[] onLineUsers) {
        // 把线程读取到的在线用户列表更新到用户列表展示界面
        SwingUtilities.invokeLater(() -> {
            onLineUserList.setListData(onLineUsers);
        });
    }

    public void setMsgToWin(String msg) {
        // 展示新的群聊消息到聊天窗口
        SwingUtilities.invokeLater(() -> {
            chatArea.append(msg);
        });
    }
}