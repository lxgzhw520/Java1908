<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/3
  时间: 14:51
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改多个同类型对象</title>
    <style>
        div {
            width: 100px;
            height: 100px;
            margin: 10px;
            background-color: rebeccapurple;
        }
    </style>
</head>
<body>
<div>我是div</div>
<div></div>
<div></div>
<div></div>
<script src="jquery-3.3.1.min.js"></script>
<script>
    <%--
    需求:
        1.将所有的div内容改为 我是div
    --%>
    $(function () {
        let $divs = $("div")
        for (let i = 0; i < $divs.length; i++) {
            $divs[i].innerHTML = "我是div"
        }
    })
</script>
</body>
</html>
