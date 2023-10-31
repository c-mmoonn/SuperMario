package com.sxt;

import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginJFrame extends JFrame {
    JTextField tf_username;  //用户名输入文本框
    JPasswordField pf_password; //用户密码输入文本框
    JButton btn_login;  //登录按钮
    JButton btn_reset; //重置按钮，用于清空已经输入的用户名和密码
    JButton btn_register;  //进行注册
    JButton btn_exit;  //退出该软件
    JLabel USER_TEXT = new JLabel("用户名:");//用户名文本标签
    JLabel PASS_TEXT = new JLabel("密码:");//密码文本标签

    public static void main(String[] args) {
        new LoginJFrame();
    }

    //在空构造器里面调用初始化方法
    public LoginJFrame() {
        super();
        initialize();
    }

    //初始化一个登录面板
    private void initialize() {
        this.setTitle("登录");
        this.setSize(600, 400);
        this.setLocation(600, 350);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  //点击关闭图标后将关闭
        tf_username = new JTextField("");
        tf_username.setBounds(180, 50, 280, 30);
        USER_TEXT.setBounds(120, 50, 60, 30);
        pf_password = new JPasswordField("");
        pf_password.setBounds(180, 100, 280, 30);
        PASS_TEXT.setBounds(120, 100, 60, 30);
        btn_login = new JButton("登录");
        btn_login.setBounds(120, 180, 70, 30);
        btn_register = new JButton("注册");
        btn_register.setBounds(210, 180, 70, 30);
        btn_reset = new JButton("重置");
        btn_reset.setBounds(300, 180, 70, 30);
        btn_exit = new JButton("退出");
        btn_exit.setBounds(390, 180, 70, 30);
        this.add(USER_TEXT);
        this.add(PASS_TEXT);
        this.add(tf_username);
        this.add(pf_password);
        this.add(btn_exit);
        this.add(btn_login);
        this.add(btn_register);
        this.add(btn_reset);
        this.setVisible(true);

        btn_exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  //退出程序
            }
        });

        btn_login.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

        btn_register.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btn_reset.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {    //按钮实现将用户名文本和密码进行清空
                tf_username.setText("");
                pf_password.setText("");
            }
        });
    }

}

