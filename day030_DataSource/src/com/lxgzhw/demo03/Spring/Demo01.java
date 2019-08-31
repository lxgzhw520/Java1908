package com.lxgzhw.demo03.Spring;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Properties;

public class Demo01 {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        Properties properties = new Properties();
        properties.load(Demo01.class.getClassLoader()
                .getResourceAsStream("druid.properties"));

        //2.创建连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //3.创建JDBCTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //4.写sql语句
        String sql = "update account set money=5000 where name=?";
        //5.执行sql语句
        int update = jdbcTemplate.update(sql, "大黄");
        //6.处理结果
        if (update > 0) {
            System.out.println("修改数据成功.");
        } else {
            System.out.println("修改数据失败.");
        }
    }
}
