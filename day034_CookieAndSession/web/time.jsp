<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 18010
  Date: 2019/9/1
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上次登录时间</title>
</head>
<body>
<%
    //1.定义一个flag,用来判断是否有lastTime
    boolean flag = false;

    //2.获取cookies
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("lastTime")) {
                //找到了
                //将时间转化
                long time = Long.parseLong(cookie.getValue());
                String formatTime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss")
                        .format(time);
                System.out.println("上次登录时间:" + formatTime);

                //更新时间
                cookie.setValue(System.currentTimeMillis() + "");
                response.addCookie(cookie);
                flag = true;
            }
        }
    }

    //3.判断flag
    if (!flag) {
        //没有设置,第一次登录
        System.out.println("第一次登录");
        Cookie lastTime = new Cookie("lastTime", System.currentTimeMillis() + "");
        response.addCookie(lastTime);
    }
%>
</body>
</html>
