<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lxgzhw.web.domain.User" %>
<%@ page import="java.util.Date" %><%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/2
  时间: 9:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>遍历数据填充表格</title>
</head>
<body>
<%
    //1.创建集合
    ArrayList<User> users = new ArrayList<>();
    //2.填充集合
    users.add(new User("楚枫", '男', new Date()));
    users.add(new User("萃萃", '女', new Date()));
    users.add(new User("大黄", '雄', new Date()));
    //3.传到request域
    request.setAttribute("users", users);
%>

<%--遍历集合,填充表格--%>
<table border="1" width="60%" align="center">
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>生日</th>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="s">
        <tr>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.birthStr}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
