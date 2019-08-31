package com.lxgzhw.demo01.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
添加记录:insert语句
 */
public class Demo02Insert {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义sql
            String sql = "insert into account values(null,'张大鹏',10000)";
            //3.获取Connection对象 DriverManager
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1",
                    "root",
                    "root"
            );
            //4.通过Connection对象创建Statement对象
            statement = connection.createStatement();
            //5.执行sql
            int i = statement.executeUpdate(sql);
            //6.处理结果
            if (i > 0) {
                System.out.println("添加记录成功.");
            } else {
                System.out.println("添加记录失败.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            //不为null才关闭,防止空指针异常
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
