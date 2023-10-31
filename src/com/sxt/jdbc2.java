package com.sxt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Scanner;
import java.util.Vector;


public class jdbc2 extends Mario{
    /*
      添加学生信息
*/static Scanner sc = new Scanner(System.in);
    public static void insert(int i) {
        Connection conn = null;
        Statement stat = null;
        try{
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //获取连接对象
            String url = "jdbc:mysql://localhost:3306/java?serverTimezone=GMT%2B8&useSSL=false";
            String username = "root";
            String password = "fangyu666999";
            conn = DriverManager.getConnection(url,username,password);
            stat = conn.createStatement();

            //4.执行sql语句，并且接收返回的结果集
            String sql="INSERT INTO java.score (历史得分) VALUES(?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,i);
            pstmt.executeUpdate();



        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void show() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try{
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //获取连接对象
            String url = "jdbc:mysql://localhost:3306/java?serverTimezone=GMT%2B8&useSSL=false";
            String username = "root";
            String password = "fangyu666999";
            conn = DriverManager.getConnection(url,username,password);

            String sql="select * from score order by 历史得分 desc;";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            //4.执行sql语句，并且接收返回的结果集

            PreparedStatement pstmt = conn.prepareStatement(sql);
            while(rs.next()){
                int score = rs.getInt("历史得分");
                System.out.println(score);
                //rs.append("得分为").append(历史得分);
            }
            JOptionPane.showMessageDialog(null, rs.toString(), "学生信息", JOptionPane.INFORMATION_MESSAGE);
            //pstmt.setInt(1);
            //pstmt.executeUpdate();



        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
