package com.sxt;

         import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.Statement;
        import javax.swing.JOptionPane;

public class jdbc3 {
    public static void show() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //获取连接对象
            String url = "jdbc:mysql://localhost:3306/java?serverTimezone=GMT%2B8&useSSL=false";
            String username = "root";
            String password = "fangyu666999";

            // 连接到数据库
            connection = DriverManager.getConnection(url,username,password);

            // 创建 Statement 对象
            statement = connection.createStatement();

            // 执行查询语句
            String query = "select * from score order by 历史得分 desc"; // 查询语句
            resultSet = statement.executeQuery(query);

            // 处理查询结果
            StringBuilder result = new StringBuilder();
            while (resultSet.next()) {
                // 读取每一行数据
                int score = resultSet.getInt("历史得分");

                // 构建显示的字符串
                result.append("得分为: ").append(score)
                        .append("\n\n");
            }

            // 在弹窗中显示查询结果
            JOptionPane.showMessageDialog(null, result.toString(), "历史得分", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接和资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
