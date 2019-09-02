# `day033` Response向客户端发送数据

> 作者: 张大鹏



## 001.常见状态码

```
1. 1xx：服务器就收客户端消息，但没有接受完成，等待一段时间后，发送1xx多状态码
2. 2xx：成功。代表：200
3. 3xx：重定向。代表：302(重定向)，304(访问缓存)
4. 4xx：客户端错误。
    * 代表：
        * 404（请求路径没有对应的资源） 
        * 405：请求方式没有对应的doXxx方法
5. 5xx：服务器端错误。代表：500(服务器内部出现异常)
```



## 002.常见响应头

```
1. Content-Type：服务器告诉客户端本次响应体数据格式以及编码格式
2. Content-disposition：服务器告诉客户端以什么格式打开响应体数据
	* in-line:默认值,在当前页面内打开
    * attachment;filename=xxx：以附件形式打开响应体。文件下载
```



## 003.`Response`对象

```
* 功能：设置响应消息
	1. 设置响应行
		1. 格式：HTTP/1.1 200 ok
		2. 设置状态码：setStatus(int sc) 
	2. 设置响应头：setHeader(String name, String value) 		
	3. 设置响应体：
		* 使用步骤：
			1. 获取输出流
				* 字符输出流：PrintWriter getWriter()
				* 字节输出流：ServletOutputStream getOutputStream()
			2. 使用输出流，将数据输出到客户端浏览器
```



## 004.重定向

```
* 重定向的特点:redirect
    1. 地址栏发生变化
    2. 重定向可以访问其他站点(服务器)的资源
    3. 重定向是两次请求。不能使用request对象来共享数据
* 转发的特点：forward
    1. 转发地址栏路径不变
    2. 转发只能访问当前服务器下的资源
    3. 转发是一次请求，可以使用request对象来共享数据
```

方法1

```java
//1. 设置状态码为302
response.setStatus(302);
//2.设置响应头location
response.setHeader("location","/day15/responseDemo2");
```

方法2

```java
//简单的重定向方法
response.sendRedirect("/day15/responseDemo2");
```

实战案例:

> 重定向方法1代码

```java
package com.lxgzhw.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
重定向
 */
@WebServlet("/demo01")
public class Demo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("演示重定向...");
        //方法1
        //1.1设置状态码
        resp.setStatus(302);
        req.setAttribute("msg","状态码+响应头设置重定向");
        //1.2设置响应头
        resp.setHeader("location","/demo02");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
```

> 接收重定向的代码
>
> 注意:
>
> 1.这里是无法接收req传递的数据的,打印结果为null

```java
package com.lxgzhw.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo02")
public class Demo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收重定向...");
        Object msg = req.getAttribute("msg");
        System.out.println(msg);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
```

> 方法2设置重定向
>
> 注意:这种方法也无法传递req域对象数据,结论就是重定向不能传递Request域对象数据,原因是重定向发生了两次请求,而转发只用一次请求

```java
package com.lxgzhw.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
重定向方法2代码
 */
@WebServlet("/demo03")
public class Demo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置消息
        req.setAttribute("msg", "sendRedirect方法重定向");
        //2.动态获取虚拟目录并重定向
        resp.sendRedirect(req.getContextPath() + "/demo02");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
```



## 005.输出字符到浏览器

```
* 步骤：
    1. 获取字符输出流
    2. 输出数据
* 注意：
	* 乱码问题：
        1. PrintWriter pw = response.getWriter();获取的流的默认编码是ISO-8859-1
        2. 设置该流的默认编码
        3. 告诉浏览器响应体使用的编码
        
        //简单的形式，设置编码，是在获取流之前设置
        response.setContentType("text/html;charset=utf-8");
```

```java
package com.lxgzhw.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
输出字符到浏览器
 */
@WebServlet("/demo04")
public class Demo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        resp.setContentType("text/html;charset=utf8");

        //2.获取字符输出流
        PrintWriter writer = resp.getWriter();

        //3.输出数据
        writer.write("哈哈哈,我终于会输出字符到浏览器了");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
```



## 006.输出字节流到浏览器

1.写`web/index.html`

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
<h1>演示字节输出流</h1>
</body>
</html>
```

2.写`java`代码

```java
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
```



## 007.输出验证码到浏览器

```java
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
```



## 008.`ServletContext`对象

概念：代表整个web应用，可以和程序的容器(服务器)来通信

获取:

```
1. 通过request对象获取
	request.getServletContext();
2. 通过HttpServlet获取
	this.getServletContext();
```

功能:

```
1. 获取MIME类型：
	* MIME类型:在互联网通信过程中定义的一种文件数据类型
		* 格式： 大类型/小类型   text/html		image/jpeg
	* 获取：String getMimeType(String file)  

2. 域对象：共享数据
    1. setAttribute(String name,Object value)
    2. getAttribute(String name)
    3. removeAttribute(String name)
	* ServletContext对象范围：所有用户所有请求的数据
	
3. 获取文件的真实(服务器)路径(相对于web目录)
	1. 方法：String getRealPath(String path)  
        String b = context.getRealPath("/b.txt");//web目录下资源访问
        System.out.println(b);
        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
		System.out.println(c);
        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
		System.out.println(a);
```



## 009.文件下载

```
* 文件下载需求：
	1. 页面显示超链接
	2. 点击超链接后弹出下载提示框
	3. 完成图片文件下载
```

1.写一个`DownloadUtils.java`下载工具类

```java
package com.lxgzhw.web.utils;

import sun.misc.BASE64Decoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/*
解决浏览器的文件名兼容问题
 */
public class DownloadUtils {
    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            //1.IE浏览器
            filename = URLEncoder.encode(filename, "utf8");
            filename = filename.replace("+", " ");
        } else {
            //2.其他浏览器
            filename = URLEncoder.encode(filename, "utf8");
        }

        return filename;
    }
}
```

2.写一个`download.html`下载页面

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>下载</title>
</head>
<body>
<a href="/download?filename=中文名.jpg">
    <img src="中文名.jpg" alt="">
    <h2>下载图片</h2>
</a>
</body>
</html>
```

3.写一个`DownloadServlet.java`下载处理类

```java
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
```

