package com.jiangyue.lanim.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.DataOutputStream;
import java.net.Socket;


public class LoginFrame extends JFrame {
    private JTextField nicknameField;
    private boolean confirmed;
    private String nickname;
    private static Socket socket;

    public LoginFrame() {
        super("Login LAN Chat");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel panel = new JPanel(new GridLayout(2, 1, 0, 10)); // 行间距为10，EN：Line border is 10
        contentPanel.add(panel, BorderLayout.CENTER);

        // Nickname label
        JPanel nicknamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel nicknameLabel = new JLabel("Nickname:");
        nicknameField = new JTextField(20);
        nicknamePanel.add(nicknameLabel);
        nicknamePanel.add(nicknameField);


        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        JButton confirmBtn = new JButton("Confirm");
        JButton cancelBtn = new JButton("Cancel");
        buttonPanel.add(confirmBtn);
        buttonPanel.add(cancelBtn);

        panel.add(nicknamePanel);
        panel.add(buttonPanel);

        // 昵称确认按钮事件监听器
        confirmBtn.addActionListener(e -> {
            nickname = nicknameField.getText().trim();
            if (nickname.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Nickname cannot be empty",
                        "Error", JOptionPane.ERROR_MESSAGE
                );
                nicknameField.requestFocus();
                return;
            } else {
                try {
                    login(nickname);
                    // 启动聊天界面, 启动聊天界面
                    new MainChatFrame(nickname, socket);
                    dispose(); // 关闭当前登录界面

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            this.nickname = nickname;
            confirmed = true;
            dispose();
        });

        cancelBtn.addActionListener(e -> {
            confirmed = false;
            dispose();
        });

        // Enter key: confirm, ESC key: cancel
        getRootPane().setDefaultButton(confirmBtn);
        getRootPane().registerKeyboardAction(e -> cancelBtn.doClick(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);

        setContentPane(contentPanel);
        pack();
        setLocationRelativeTo(null);
        nicknameField.requestFocusInWindow();
        setVisible(true);
    }

    private static void login(String nickname) throws Exception {
        // 立即发送消息给服务端
        // 1、创建 socket 管道请求与服务器端 socket 的连接
        socket = new Socket(Constant.SERVER_IP, Constant.SERVER_PORT);
        // 2、立即发送消息类型 1 和自己的昵称给服务器
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeInt(1);
        dos.writeUTF(nickname);
    }
}
