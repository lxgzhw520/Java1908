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
@WebServlet("/demo03")
public class Demo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie time = new Cookie("time", "设置存活时间为7天");
        Cookie where = new Cookie("where", "同顶级域名可用");
        Cookie where1 = new Cookie("where1", "根目录下可用");

        //1.设置存活时间
        time.setMaxAge(3600*24*7);

        //2.设置根目录可用
        where1.setPath("/");

        //3.设置同顶级域名可用
        where.setDomain("lxgzhw.com");

        //4.转发到demo4,从demo4获取cookie
        resp.addCookie(time);
        resp.addCookie(where);
        resp.addCookie(where1);
        req.getRequestDispatcher("/demo04").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
