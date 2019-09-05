<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/3
  时间: 15:01
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基本选择器</title>
    <style>
        div {
            display: inline-block;
            width: 100px;
            height: 100px;
            border: 1px solid rebeccapurple;
            margin: 20px;
        }

        span {
            display: block;
            width: 50px;
            height: 50px;
            background-color: yellow;
            border: 1px solid red;
            margin: 10px;
        }
    </style>
</head>
<body>
<div id="one">
    id为one
</div>
<div class="mini">
    class为mini
</div>
<div id="two">
    id为two
</div>
<span>我是span</span>
<span>我是span</span>
<span>我是span</span>
<br>
<input type="button" value="保存" class="mini" name="ok" class="mini"/>
<input type="button" value="改变 id 为 one 的元素的背景色为 红色" id="b1"/>
<input type="button" value=" 改变元素名为 <div> 的所有元素的背景色为 红色" id="b2"/>
<input type="button" value=" 改变 class 为 mini 的所有元素的背景色为 红色" id="b3"/>
<input type="button" value=" 改变所有的<span>元素和 id 为 two 的元素的背景色为红色" id="b4"/>


<script src="jquery-3.3.1.min.js"></script>
<script>
    $(function () {
        // <input type="button" value="改变 id 为 one 的元素的背景色为 红色" id="b1"/>
        $("#b1").click(function () {
            $("#one").css({"background": "red"})
        })
        //<input type="button" value=" 改变元素名为 <div> 的所有元素的背景色为 红色" id="b2"/>
        $("#b2").click(function () {
            $("div").css({"background": "red"})
        })
        //改变 class 为 mini 的所有元素的背景色为 红色
        $("#b3").click(function () {
            $(".mini").css({"background": "red"})
        })
        //改变所有的<span>元素和 id 为 two 的元素的背景色为红色
        $("#b4").click(function () {
            $("span,#two").css({"background-color": "red"})
        })
    })
</script>
</body>
</html>
