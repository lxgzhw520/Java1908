package com.lxgzhw.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
获取请求头数据
 */
@WebServlet("/demo02")
public class Demo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取所有的请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        //根据名称获取值
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            String header = req.getHeader(s);
            System.out.println(s + ":" + header);
        }
    }
}
