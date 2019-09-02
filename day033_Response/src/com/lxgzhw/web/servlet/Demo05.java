package com.lxgzhw.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
输出字节数据到浏览器
 */
@WebServlet("/demo05")
public class Demo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置字符编码
        resp.setContentType("text/html;charset=utf8");

        //2.获取网络字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();

        //3.定义本地字节输入流
        ServletContext servletContext = this.getServletContext();
        String indexPath = servletContext.getRealPath("/index.html");
        File file = new File(indexPath);
        FileInputStream fileInputStream = new FileInputStream(file);

        //4.输出数据到浏览器
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }

        //5.释放资源
        fileInputStream.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
