package com.lxgzhw.web.download;

import com.lxgzhw.web.utils.DownloadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数,文件名称
        String filename = req.getParameter("filename");
        //2.使用字节输入流读取文件
        ServletContext servletContext = this.getServletContext();
        String filePath = servletContext.getRealPath(filename);
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));

        //3.设置响应头为下载
        String fileMimeType = servletContext.getMimeType(filename);
        resp.setHeader("content-type", fileMimeType);

        //4.解决中文名问题
        String agent = req.getHeader("user-agent");
        filename = DownloadUtils.getFileName(agent, filename);
        //4.1设置文件打开方式为附件形式
        resp.setHeader("content-disposition",
                "attachment;filename=" + filename);

        //5.输出文件
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            resp.getOutputStream().write(bytes, 0, len);
        }

        //6.关闭流
        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
