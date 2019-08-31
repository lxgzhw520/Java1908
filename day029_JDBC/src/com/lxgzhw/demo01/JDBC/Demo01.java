package com.lxgzhw.demo01.JDBC;

import java.sql.*;

public class Demo01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库连接对象DriverManager
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db1",
                "root",
                "root");
        //3.定义sql语句
        String sql = "select *from students";
        //4.获取执行sql的对象 Statement
        Statement statement = connection.createStatement();
        //5.执行sql
        ResultSet resultSet = statement.executeQuery(sql);
        //6.处理结果
        System.out.println(resultSet);
        //7.释放资源
        statement.close();
        connection.close();
    }
}
