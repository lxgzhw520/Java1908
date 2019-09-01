package com.lxgzhw.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
获取请求行数据
 */
@WebServlet("/demo01")
public class Demo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方法 getMethod()
        String method = req.getMethod();
        System.out.println("请求方式:" + method);
        System.out.println("-------------------------------");

        //获取虚拟根目录
        String contextPath = req.getContextPath();
        System.out.println("虚拟根目录:" + contextPath);
        System.out.println("-------------------------------");

        //获取Servlet路径
        String servletPath = req.getServletPath();
        System.out.println("Servlet路径:" + servletPath);
        System.out.println("-------------------------------");

        //获取get请求参数
        String queryString = req.getQueryString();
        System.out.println("请求参数:" + queryString);
        System.out.println("-------------------------------");

        //获取URI
        String requestURI = req.getRequestURI();
        System.out.println("统一资源标识符:" + requestURI);
        System.out.println("-------------------------------");

        //获取协议及版本
        String protocol = req.getProtocol();
        System.out.println("协议及版本:" + protocol);
        System.out.println("-------------------------------");

        //获取客户机的ip地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println("用户ip地址:" + remoteAddr);
        System.out.println("-------------------------------");
    }
}
