<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/2
  时间: 8:54
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //1.存储数据
    session.setAttribute("name", "张大鹏");
    request.setAttribute("name", "萃萃");
%>
<h3>获取值</h3>
<p>${requestScope.name}</p>
<p>${sessionScope.name}</p>
</body>
</html>
