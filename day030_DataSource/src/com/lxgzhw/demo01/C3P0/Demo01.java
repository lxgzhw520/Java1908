package com.lxgzhw.demo01.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
获取C3P0的数据库连接池
 */
public class Demo01 {
    public static void main(String[] args) throws SQLException {
        //1.创建数据库连接池对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2.获取连接对象
        Connection connection = comboPooledDataSource.getConnection();
        //3.使用
        //3.1 定义sql语句
        String sql = "insert into account values(null,?,?)";
        //3.2 预编译sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.3 执行sql语句
        preparedStatement.setString(1, "萃萃");
        preparedStatement.setDouble(2, 10000);
        int i = preparedStatement.executeUpdate();
        //3.4 处理结果
        if (i > 0) {
            System.out.println("添加数据成功.");
        } else {
            System.out.println("添加数据失败.");
        }
    }
}
