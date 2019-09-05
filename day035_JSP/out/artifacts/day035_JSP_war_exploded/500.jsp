<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/2
  时间: 8:40
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isErrorPage="true"
%>
<html>
<head>
    <title>理想国真恵玩</title>
</head>
<body>
<h1>服务器正忙,请稍后.....</h1>
<%
    //错误页面可以使用exception内置对象
    String message = exception.getMessage();
    out.print(message);
%>
</body>
</html>
