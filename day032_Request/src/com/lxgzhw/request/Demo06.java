package com.lxgzhw.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/demo06")
public class Demo06 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取参数的通用方法1
        String username = req.getParameter("username");
        System.out.println("用户名:" + username);
        System.out.println("-------------------------------");

        //获取参数的通用方法2
        Map<String, String[]> parameterMap = req.getParameterMap();
        parameterMap.keySet().stream().forEach(k -> {
            String v = req.getParameter(k);
            System.out.println(k + "---->>>>" + v);

        });
    }
}
