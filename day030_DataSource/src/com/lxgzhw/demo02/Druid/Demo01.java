package com.lxgzhw.demo02.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class Demo01 {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        Properties properties = new Properties();
        InputStream resourceAsStream = Demo01.class.getClassLoader()
                .getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        //2.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //3.获取连接
        Connection connection = dataSource.getConnection();
        //4.使用
        //4.1 定义sql语句
        String sql = "insert into account values(null,?,?)";
        //4.2 预编译sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "大黄");
        preparedStatement.setDouble(2, 3000);
        //4.3 执行sql语句
        int i = preparedStatement.executeUpdate();
        //4.4 处理结果
        if (i > 0) {
            System.out.println("添加数据成功.");
        } else {
            System.out.println("添加数据失败.");
        }
    }
}
