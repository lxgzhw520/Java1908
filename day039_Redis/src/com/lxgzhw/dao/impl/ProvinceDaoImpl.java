package com.lxgzhw.dao.impl;

import com.lxgzhw.dao.ProvinceDao;
import com.lxgzhw.domain.Province;
import com.lxgzhw.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    private JdbcTemplate template =
            new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        //1.定义sql
        String sql = "select *from province";
        //2.执行sql
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<>(Province.class));
        //3.返回数据
        return list;
    }
}
