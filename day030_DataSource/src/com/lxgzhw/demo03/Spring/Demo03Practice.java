package com.lxgzhw.demo03.Spring;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Demo03Practice {

    //修改楚枫的money为20000
    @Test
    public void test01() throws Exception {
        JdbcTemplate exe = JDBCUtils.getExe();
        //1.写sql语句
        String sql = "update account set money=? where name=?";

        //2.执行sql语句
        int count = exe.update(sql, 20000, "楚枫");

        //3.结果
        if (count > 0) {
            System.out.println("修改数据成功.");
        } else {
            System.out.println("修改数据失败.");
        }
    }

    //添加一条记录
    @Test
    public void test02() throws Exception {
        JdbcTemplate exe = JDBCUtils.getExe();
        String sql = "insert into account values (null,?,?)";
        int count = exe.update(sql, "刘国栋", 3999);
        if (count > 0) {
            System.out.println("添加数据成功.");
        }
    }

    //查询一条记录封装为map集合
    @Test
    public void test03() throws Exception {
        JdbcTemplate exe = JDBCUtils.getExe();
        String sql = "select id,name,money from account where name=?";
        Map<String, Object> map = exe.queryForMap(sql, "楚枫");
        System.out.println(map);
    }

    //查询所有记录,封装为List
    @Test
    public void test04() throws Exception {
        JdbcTemplate exe = JDBCUtils.getExe();
        String sql = "select id,name,money from account";
        List<Map<String, Object>> maps = exe.queryForList(sql);
        maps.stream().forEach(System.out::println);
    }

    //查询所有记录,想封装为Account对象,再封装为List集合
    @Test
    public void test05() throws Exception {
        JdbcTemplate exe = JDBCUtils.getExe();
        String sql = "select id,name,money from account";
        List<Account> query = exe.query(sql, new BeanPropertyRowMapper<>(Account.class));
        query.stream().forEach(System.out::println);
    }

    //查询总记录数
    @Test
    public void test06() throws Exception {
        JdbcTemplate exe = JDBCUtils.getExe();
        String sql = "select count(id) from account";
        Long count = exe.queryForObject(sql, Long.class);
        System.out.println("总记录数:" + count);
    }

}
