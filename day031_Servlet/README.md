# `day031` `Servlet`

> 作者: 张大鹏

## 001.概念

> 运行在服务器端的小程序
>
> `Servlet`就是一个接口，定义了Java类被浏览器访问到(tomcat识别)的规则。
>
> 将来我们自定义一个类，实现`Servlet`接口，复写方法。



## 002.快速入门

1.写一个`Servlet`接口实现类

```java
package com.lxgzhw.demo01.Servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo01 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化方法");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("提供服务的方法");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("服务器正常关闭的方法");
    }
}
```

2.在`web/WEB-INF/web.xml`中写

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <servlet>
        <servlet-name>demo01</servlet-name>
        <servlet-class>com.lxgzhw.demo01.Servlet.ServletDemo01</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>demo01</servlet-name>
        <url-pattern>/demo01</url-pattern>
    </servlet-mapping>
</web-app>
```

3.浏览器访问`/demo01`



## 003.执行原理

1. 当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的`Servlet`的资源路径
2. 查找`web.xml`文件，是否有对应的`<url-pattern>`标签体内容。
3. 如果有，则在找到对应的`<servlet-class>`全类名
4. `tomcat`会将字节码文件加载进内存，并且创建其对象
5. 调用其方法



## 004.声明周期方法

1. 被创建：执行`init`方法，只执行一次
2. 提供服务：执行`service`方法，执行多次
3. 被销毁：执行`destroy`方法，只执行一次



## 005.使用注解

> 3.0以后支持注解配置。可以不需要`web.xml`了

```java
package com.lxgzhw.demo01.Servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/demo02")
public class ServletDemo02 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("这是通过Servlet注解配置的方法");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
```

