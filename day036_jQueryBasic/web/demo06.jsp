<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/3
  时间: 15:37
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>层级选择器</title>
</head>
<body>
<div>父元素</div>
<div>父元素</div>
<div>父元素</div>
<div>
    <div>子元素</div>
    <div>子元素</div>
    <div>子元素</div>
    <div>子元素</div>
    <div>
        <div>孙子元素</div>
        <div>孙子元素</div>
        <div>孙子元素</div>
        <div>
            <div>孙子的子元素</div>
            <div>孙子的子元素</div>
            <div>孙子的子元素</div>
            <div>孙子的子元素</div>
        </div>
    </div>
</div>
<button>1.改变 body 内所有 div 的背景色为红色</button>
<button>2.改变 body 内子 div 的背景色为 红色</button>
<script src="jquery-3.3.1.min.js"></script>
<script>
    /*
    1.改变 <body> 内所有 <div> 的背景色为红色
    2.改变 <body> 内子 <div> 的背景色为 红色
     */

    /*
    分析:
    通过查询文档
    1.ancestor descendant:在给定的祖先元素下匹配所有的后代元素
    2.parent > child:在给定的父元素下匹配所有的子元素
    3.prev + next:匹配所有紧接在 prev 元素后的 next 元素
    4.prev ~ siblings:匹配 prev 元素之后的所有 siblings 元素
     */
    $(function () {
        $("button:nth-of-type(1)").click(function () {
            $("body div").css({"background": "red"})
        })
        $("button:nth-of-type(2)").click(function () {
            $("body>div").css({"background": "red"})
        })

    })
</script>
</body>
</html>
