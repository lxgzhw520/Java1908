package com.lxgzhw.demo02.uitil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/*
封装JDBC工具类
 */
public class JDBCUtils {
    //定义四个私有静态变量
    /*
    1.静态代码块只能用静态变量
    2.这些变量不想被外部访问,只在内部使用
     */
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 文件的读取.只需要读取一次,使用静态代码块
     * 静态代码块的特点是只会执行一次
     */
    static {
        //读取资源文件,获取值
        try {
            //1.创建Properties集合类
            Properties properties = new Properties();
            //2.加载配置文件
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();
            properties.load(new FileReader(path));
            //3.获取数据并赋值
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            //4.注册驱动
            Class.forName(driver);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Connection连接
     *
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * DDL操作后释放资源
     *
     * @param statement  执行sql语句的对象
     * @param connection 连接数据库的对象
     */
    public static void close(Statement statement, Connection connection) {
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

    /**
     * DQL操作后释放资源
     *
     * @param resultSet  结果集对象
     * @param statement  执行sql的对象
     * @param connection 连接数据库的对象
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
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
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
