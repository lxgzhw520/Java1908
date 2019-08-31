package com.lxgzhw.demo01.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
修改数据库表记录:update
 */
public class Demo03Update {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象 DriverManager
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1",
                    "root",
                    "root"
            );
            //3.获取Statement对象
            statement = connection.createStatement();
            //4.定义sql
            String sql = "update account set money=2000 where id=1";
            //5.执行sql
            int i = statement.executeUpdate(sql);
            //6.结果
            if (i > 0) {
                System.out.println("修改记录成功.");
            } else {
                System.out.println("修改记录失败.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
