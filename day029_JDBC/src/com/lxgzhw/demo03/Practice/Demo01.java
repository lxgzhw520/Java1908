package com.lxgzhw.demo03.Practice;

import com.lxgzhw.demo02.uitil.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

/*
练习1:定义一个方法，查询students表的数据将其封装为对象，然后装载集合，返回。
 */
public class Demo01 {
    public static void main(String[] args) {
        //1.获取集合
        ArrayList<Student> allStudents = getAllStudents();
        //2.遍历集合
        allStudents.stream().forEach(System.out::println);
    }

    /*
    分析:
        1.Students表字段
          id name age math english chinese birthday insert_time
        2.需要根据字段创建对应的Student类对象
        3.查询数据库中的students表,将结果封装为对象
        4.将所有的对象装到一个集合中
        5.将集合返回
            这里选ArrayList集合
     */
    static ArrayList<Student> getAllStudents() {
        //0.定义一个空集合
        ArrayList<Student> students = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            students = new ArrayList<>();
            //1.获取连接
            connection = JDBCUtils.getConnection();
            //2.定义sql语句
            String sql = "select *from students";
            //3.执行sql语句
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            //4.封装对象,装到集合
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int english = resultSet.getInt("english");
                int math = resultSet.getInt("math");
                int chinese = resultSet.getInt("chinese");
                Date birthday = resultSet.getDate("birthday");
                Date insert_time = resultSet.getDate("insert_time");
                //4.1创建对象
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setEnglish(english);
                student.setChinese(chinese);
                student.setMath(math);
                student.setBirthday(birthday);
                student.setInsert_time(insert_time);
                //4.2将对象装到集合中
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
        //5.返回集合
        return students;
    }
}
