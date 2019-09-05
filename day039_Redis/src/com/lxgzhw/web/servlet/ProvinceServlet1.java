package com.lxgzhw.web.servlet;

import com.lxgzhw.domain.Province;
import com.lxgzhw.service.impl.ProvinceServiceImpl;
import com.lxgzhw.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
返回所有的省份数据
 */
@WebServlet("/provinceServlet1")
public class ProvinceServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            JdbcTemplate template =
                    new JdbcTemplate(JDBCUtils.getDataSource());
            String sql = "select *from province";
            List<Province> query = template.query(sql, new BeanPropertyRowMapper<>(Province.class));
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
