<%@ page import="java.util.ArrayList" %><%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/2
  时间: 9:20
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>for</title>
</head>
<body>
<%--
foreach:相当于java代码的for语句
    1. 完成重复的操作
        * 属性：
            begin：开始值
            end：结束值
            var：临时变量
            step：步长
            varStatus:循环状态对象
                index:容器中元素的索引，从0开始
                count:循环次数，从1开始
    2.注意:foreach包左又包右
--%>
<%--打印10次HelloWorld--%>
<c:forEach begin="1" end="10" step="1" varStatus="s">
    <h3>HelloWorld---${s.count}</h3>
</c:forEach>


<%--
 2. 遍历容器
    * 属性：
        items:容器对象
        var:容器中元素的临时变量
        varStatus:循环状态对象
            index:容器中元素的索引，从0开始
            count:循环次数，从1开始
 --%>
<%--1.创建列表--%>
<%
    ArrayList<String> strings = new ArrayList<>();
    strings.add("楚枫");
    strings.add("萃萃");
    strings.add("大黄");
    request.setAttribute("names",strings);
%>
<%--2.遍历列表--%>
<c:forEach items="${names}" var="i" varStatus="name">
    <h3>${name.index} ${name.count} ${i}</h3>
</c:forEach>
</body>
</html>
