<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/2
  时间: 9:15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>choose</title>
</head>
<body>
<%
    //判断今天是星期几
    request.setAttribute("n", 3);
%>
<c:choose>
    <c:when test="${n==1}">星期一</c:when>
    <c:when test="${n==2}">星期二</c:when>
    <c:when test="${n==3}">星期三</c:when>
    <c:when test="${n==4}">星期四</c:when>
    <c:when test="${n==5}">星期五</c:when>
    <c:when test="${n==6}">星期六</c:when>
    <c:when test="${n==7}">星期天</c:when>

    <c:otherwise>数字输入有误</c:otherwise>
</c:choose>
</body>
</html>
