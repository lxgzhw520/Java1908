<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/3
  时间: 16:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>隔行换色</title>
</head>
<body>
<table border="1" width="60%" align="center">
    <tr>
        <th>#</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
    </tr>
    <tr>
        <td>1</td>
        <td>张大鹏</td>
        <td>男</td>
        <td>22</td>
    </tr>
    <tr>
        <td>1</td>
        <td>张大鹏</td>
        <td>男</td>
        <td>22</td>
    </tr>
    <tr>
        <td>1</td>
        <td>张大鹏</td>
        <td>男</td>
        <td>22</td>
    </tr>
    <tr>
        <td>1</td>
        <td>张大鹏</td>
        <td>男</td>
        <td>22</td>
    </tr>
    <tr>
        <td>1</td>
        <td>张大鹏</td>
        <td>男</td>
        <td>22</td>
    </tr>
    <tr>
        <td>1</td>
        <td>张大鹏</td>
        <td>男</td>
        <td>22</td>
    </tr>
    <tr>
        <td>1</td>
        <td>张大鹏</td>
        <td>男</td>
        <td>22</td>
    </tr>
    <tr>
        <td>1</td>
        <td>张大鹏</td>
        <td>男</td>
        <td>22</td>
    </tr>
    <tr>
        <td>1</td>
        <td>张大鹏</td>
        <td>男</td>
        <td>22</td>
    </tr>
</table>
<script src="jquery-3.3.1.min.js"></script>
<script>
    /*
    分析:给tr上背景色即可
     */
    $("tr:odd").css({"background": "red"})
    $("tr:even").css({"background": "blue"})
    //第一行单独设置
    $("tr:first").css({"background":"yellow"})
</script>
</body>
</html>
