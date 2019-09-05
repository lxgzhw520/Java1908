package com.lxgzhw.dao.impl;

import com.lxgzhw.dao.ProvinceDao;
import com.lxgzhw.domain.Province;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    @Override
    public List<Province> findAll() throws Exception {
        //1.创建集合
        ArrayList<Province> provinces = new ArrayList<>();

        //2.创建连接对象,操作数据库的对象,结果集对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //3.捕获异常
        try {
            //3.1加载驱动类
            Class.forName("com.mysql.jdbc.Driver");

            //3.2实例化连接对象,操作对象,结果集对象
            connection = DriverManager.getConnection("jdbc:mysql:///day039",
                    "root","root");
            preparedStatement = connection.prepareCall("select *from province");
            resultSet = preparedStatement.executeQuery();

            //3.3把查询结果封装到集合
            while (resultSet.next()) {
                provinces.add(new Province(
                        resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //4.返回集合
        return provinces;
    }
}
