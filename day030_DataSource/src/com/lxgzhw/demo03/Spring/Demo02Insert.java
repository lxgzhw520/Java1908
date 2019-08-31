package com.lxgzhw.demo03.Spring;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Properties;

public class Demo02Insert {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        Properties properties = new Properties();
        properties.load(Demo02Insert.class.getClassLoader()
                .getResourceAsStream("druid.properties"));

        //2.创建连接池对象 DruidDataSourceFactory
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //3.获取JDBCTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //4.定义sql语句
        String sql = "insert into account values(null,?,?)";

        //5.编译sql语句并执行
        int count = jdbcTemplate.update(sql, "刘国兵", 4888);

        //6.处理结果
        if (count > 0) {
            System.out.println("添加数据成功.");
        }
    }
}
