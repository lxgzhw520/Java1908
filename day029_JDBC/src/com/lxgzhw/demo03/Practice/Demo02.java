package com.lxgzhw.demo03.Practice;
/*
练习:用户输入账号密码,连接数据库查询,判断账号密码是否正确
 */

import com.lxgzhw.demo02.uitil.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/*
分析:
    1.用户录入用Scanner
    2.没有数据库表需要创建
    3.使用JDBCUtils工具类获取连接
    4.使用PrepareStatement.executeQuery()查询
    5.判断是否有next(),没有则表示没有数据,账号密码不存在或错误
    6.使用JDBCUtils释放资源
 */
public class Demo02 {
    public static void main(String[] args) {
        //1.创建要用到的Connection,ResultSet,Statement对象
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            //2.获取Connection和Statement对象
            connection = JDBCUtils.getConnection();
            //3.获取用户输入的账号密码
            System.out.println("您正在使用后台管理系统,此操作需要登录账号密码.");
            System.out.println("请输入您的账号:");
            Scanner sc = new Scanner(System.in);
            String username = sc.next();
            System.out.println("请输入您的密码:");
            String password = sc.next();
            System.out.println("账号密码正在验证中,请稍后...");
            //4.定义sql语句
            String sql = "select id from users where username=? and password=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            //5.执行sql语句
            resultSet = statement.executeQuery();
            //6.根据结果判断登录是否成功
            if (resultSet.next()) {
                System.out.println("登录成功.");
            } else {
                System.out.println("用户名或密码错误.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, statement, connection);
        }
    }
}
