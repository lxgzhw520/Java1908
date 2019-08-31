package com.lxgzhw.demo01.JDBC;

import java.sql.*;

/*
jdbc操作数据库表:查询记录
 */
public class Demo05DQL {
    public static void main(String[] args) {
        //1.创建Connection,Statement,ResultSet对象
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try{
            //2.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3.实现Connection对象和Statement对象
            connection= DriverManager.getConnection(
                    "jdbc:mysql:///db1",
                    "root",
                    "root"
            );
            statement=connection.createStatement();
            //4.定义sql语句
            String sql="select *from students";
            //5.执行SQL语句,把结果装在ResultSet对象中
            resultSet=statement.executeQuery(sql);
            /*
            注意:
                增伤改也就是DDL用executeUpdate方法
                查询也就是DQL用executeQuery方法
             */
            //6.处理结果
            while (resultSet.next()){
                //根据字段获取数据
                //id name age math english chinese birthday insert_time
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                int english=resultSet.getInt("english");
                int math=resultSet.getInt("math");
                int chinese=resultSet.getInt("chinese");
                Date birthday=resultSet.getDate("birthday");
                Date insert_time=resultSet.getDate("insert_time");
                System.out.println("id="+id);
                System.out.println("姓名="+name);
                System.out.println("分数="+"语文:"+chinese+"数学:"+math+"英语:"+english);
                System.out.println("生日:"+birthday);
                System.out.println("添加时间:"+insert_time);
                System.out.println("-------------------------------");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet!=null){
                try {
                    resultSet.close();
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
