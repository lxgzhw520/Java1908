<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/1
  时间: 21:10
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/login" method="post">
    <table border="1" width="60%" align="center">
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="text" name="password">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <img src="/captcha" alt="" id="captcha">
            </td>
        </tr>
        <tr>
            <td>验证码</td>
            <td>
                <input type="text" name="captcha">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="确认">
            </td>
        </tr>
    </table>
</form>
<script>
    window.onload = function (ev) {
        document.getElementById("captcha").onclick = function (ev1) {
            this.src = "/captcha?time=" + new Date().getTime();
        }
    }
</script>
</body>
</html>
