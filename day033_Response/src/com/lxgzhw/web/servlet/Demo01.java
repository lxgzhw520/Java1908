package com.lxgzhw.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
重定向
 */
@WebServlet("/demo01")
public class Demo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("演示重定向...");
        //方法1
        //1.1设置状态码
        resp.setStatus(302);
        req.setAttribute("msg","状态码+响应头设置重定向");
        //1.2设置响应头
        resp.setHeader("location","/demo02");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
