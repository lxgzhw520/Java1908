<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/3
  时间: 15:00
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>绑定点击事件</title>
</head>
<body>
<button>点击我</button>
<script src="jquery-3.3.1.min.js"></script>
<script>
    $("button").click(function () {
        alert("点击我...")
    })
</script>
</body>
</html>
