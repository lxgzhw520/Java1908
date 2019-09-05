package com.lxgzhw.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/*

 */
@WebServlet("/checkUser")
public class CheckUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取用户名
        String username = req.getParameter("username");
        resp.setContentType("application/json;charset=utf8");
        //2.判断用户名是否存在
        //3.返回给前端
        HashMap<String, Object> json = new HashMap<>();
        if (username.equals("lxgzhw")) {
            json.put("isExist", true);
            json.put("msg", "用户名已存在");
        } else {
            json.put("isExist", false);
            json.put("msg", "用户名可用");
        }
        new ObjectMapper().writeValue(resp.getWriter(), json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
