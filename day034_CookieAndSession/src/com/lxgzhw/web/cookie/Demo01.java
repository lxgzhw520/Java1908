package com.lxgzhw.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
设置cookie
 */
@WebServlet("/demo01")
public class Demo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("正在访问demo01....");
        //设置cookie
        Cookie cookie = new Cookie("msg", "我终于会用Cookie了");
        resp.addCookie(cookie);
        //跳转到demo02
        req.getRequestDispatcher("/demo02").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
