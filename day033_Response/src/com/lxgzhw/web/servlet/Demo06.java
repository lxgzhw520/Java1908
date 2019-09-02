package com.lxgzhw.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/*
输出验证码到浏览器
 */
@WebServlet("/demo06")
public class Demo06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.定义验证码图片的宽高
        int width = 100, height = 50;

        //2.创建验证码图片对象
        BufferedImage img =
                new BufferedImage(width, height,
                        BufferedImage.TYPE_INT_RGB);

        //3.填充背景色
        Graphics graphics = img.getGraphics();//画笔
        graphics.setColor(Color.pink);//画笔颜色
        graphics.fillRect(0, 0, width, height);//填充矩形

        //4.画边框
        graphics.setColor(Color.blue);
        graphics.drawRect(0, 0, width - 1, height - 1);

        //5.生成随机字符
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            //5.1验证码每个字符的索引
            int index = random.nextInt(str.length());
            //5.2获取字符
            char c = str.charAt(index);
            //5.4写验证码
            graphics.drawString(c + "", width / 5 * i + 10, height / 2);
        }

        //6.画干扰线
        graphics.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }

        //7.输出图片到页面
        ImageIO.write(img, "jpg", resp.getOutputStream());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
