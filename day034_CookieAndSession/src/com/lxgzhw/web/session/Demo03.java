package com.lxgzhw.web.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/*

 */
@WebServlet("/sessionDemo03")
public class Demo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取session
        HttpSession session = req.getSession();
        System.out.println(session);

        //2.设置浏览器关闭后,session也相同
        Cookie jsessionid = new Cookie("JSESSIONID", session.getId());
        jsessionid.setMaxAge(3600 * 24);
        resp.addCookie(jsessionid);

        //3.比较第一次访问和关闭浏览器后访问
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    System.out.println(cookie.getValue());
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
