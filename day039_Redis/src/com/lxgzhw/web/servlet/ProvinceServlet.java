package com.lxgzhw.web.servlet;

import com.lxgzhw.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
返回所有的省份数据
 */
@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------------------------");
        //1.调用service查询
        String allJson = new ProvinceServiceImpl().findAllJson();
        System.out.println(allJson);
        //2.响应
        resp.setContentType("application/json;charset=utf8");
        resp.getWriter().write(allJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
