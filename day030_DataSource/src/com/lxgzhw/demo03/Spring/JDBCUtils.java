package com.lxgzhw.demo03.Spring;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class JDBCUtils {
    public static JdbcTemplate getExe() throws Exception {

        //1.加载配置文件
        Properties properties = new Properties();
        properties.load(Demo03Practice.class.getClassLoader()
                .getResourceAsStream("druid.properties"));

        //2.创建Datasource
        DataSource dataSource = DruidDataSourceFactory
                .createDataSource(properties);

        //3.创建JDBCTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //4.返回JDBCTemplate
        return jdbcTemplate;
    }
}
