package com.lxgzhw.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

/*
记住用户的上次登录时间
分析:
    1.使用cookie记住lastTime
    2.时间需要格式化
 */
@WebServlet("/demo05")
public class Demo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.定义一个flag,用来判断是否有lastTime
        boolean flag = false;

        //2.获取cookies
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastTime")) {
                    //找到了
                    //将时间转化
                    long time = Long.parseLong(cookie.getValue());
                    String formatTime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss")
                            .format(time);
                    System.out.println("上次登录时间:" + formatTime);

                    //更新时间
                    cookie.setValue(System.currentTimeMillis() + "");
                    resp.addCookie(cookie);
                    flag = true;
                }
            }
        }

        //3.判断flag
        if (!flag) {
            //没有设置,第一次登录
            System.out.println("第一次登录");
            Cookie lastTime = new Cookie("lastTime", System.currentTimeMillis() + "");
            resp.addCookie(lastTime);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
