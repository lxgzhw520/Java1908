package com.lxgzhw.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo08")
public class Demo08 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //转发并携带数据到 demo09
        System.out.println("这里是demo08");
        req.setAttribute("msg","可以携带数据转发");
        req.getRequestDispatcher("/demo09").forward(req,resp);
    }
}
