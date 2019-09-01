package com.lxgzhw.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo03")
public class Demo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String header = req.getHeader("user-agent");
        if (header.contains("Chrome")) {
            System.out.println("兼容谷歌浏览器...");
        } else if (header.contains("Firefox")) {
            System.out.println("兼容火狐浏览器....");
        } else {
            System.out.println("兼容其他浏览器...");
        }
    }
}
