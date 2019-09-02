package com.lxgzhw.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*

 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理用户登录
        //主要演示处理验证码
        //1.获取验证码
        String captcha = req.getParameter("captcha");
        HttpSession session = req.getSession();
        String captcha1 = (String) session.getAttribute("captcha");

        //2.比较验证码
        if (captcha.equalsIgnoreCase(captcha1)){
            //3.打印信息
            System.out.println("验证码正确");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
