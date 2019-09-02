package com.lxgzhw.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
输出字符到浏览器
 */
@WebServlet("/demo04")
public class Demo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        resp.setContentType("text/html;charset=utf8");

        //2.获取字符输出流
        PrintWriter writer = resp.getWriter();

        //3.输出数据
        writer.write("哈哈哈,我终于会输出字符到浏览器了");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
