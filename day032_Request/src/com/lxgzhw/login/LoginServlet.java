package com.lxgzhw.login;

import com.lxgzhw.dao.UserDao;
import com.lxgzhw.login.domain.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //1.获取用户名密码
        req.setCharacterEncoding("utf8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("用户名:" + username);
        System.out.println("密码:" + password);
        System.out.println("-------------------------------");

        //2.封装loginUser对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        System.out.println(loginUser);
        System.out.println("-------------------------------");

        //3.调用UserDao登录方法
        //User user = new UserDao().login(loginUser);
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        System.out.println(user);
        System.out.println("-------------------------------");

        //4.处理结果
        if (user != null) {
            //登录成功
            //将数据传过去
            req.setAttribute("user", user);
            req.getRequestDispatcher("loginSuccess").forward(req, resp);
        } else {
            req.getRequestDispatcher("loginFail").forward(req, resp);
        }

    }
}
