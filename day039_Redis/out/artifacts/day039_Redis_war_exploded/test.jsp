<%@ page import="com.lxgzhw.service.impl.ProvinceServiceImpl" %><%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/4
  时间: 23:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<%
    String allJson = new ProvinceServiceImpl().findAllJson();
    out.write(allJson);
%>
</body>
</html>
