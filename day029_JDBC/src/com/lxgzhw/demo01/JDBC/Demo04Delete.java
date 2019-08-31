package com.lxgzhw.demo01.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
jdbc删除数据库表记录:delete
 */
public class Demo04Delete {
    public static void main(String[] args) {
        //1.定义Connection对象和Statement对象
        Connection connection=null;
        Statement statement=null;
        try {
            //2.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3.创建Connection和Statement对象
            connection= DriverManager.getConnection(
                    ///表示默认本地和默认3306端口
                    "jdbc:mysql:///db1",
                    "root",
                    "root"
            );
            statement=connection.createStatement();
            //4.创建sql语句并执行
            String sql="delete from account where id=1";
            int i = statement.executeUpdate(sql);
            //5.处理结果
            if (i>0){
                System.out.println("删除记录成功.");
            }else {
                System.out.println("删除记录失败.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
