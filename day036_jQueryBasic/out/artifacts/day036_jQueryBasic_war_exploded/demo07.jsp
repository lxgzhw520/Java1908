<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/3
  时间: 15:46
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基本过滤选择器</title>
    <style>
        div {
            width: 10px;
            height: 10px;
            border: 1px solid red;
            margin: 20px;
        }

        h1, h2, h3, h4, h5, h6 {
            display: block;
            width: 10px;
            height: 10px;
            background-color: gold;
            margin: 10px;
        }

        button {
            margin: 10px;
        }
    </style>
</head>
<body>
<div class="one"></div>
<div class="one"></div>
<div class="one"></div>
<div class="one"></div>
<div></div>
<div></div>
<div></div>
<div></div>
<h2></h2>
<h1></h1>
<h2></h2>
<h3></h3>
<h4></h4>
<h5></h5>
<h6></h6>
<button>1.改变第一个 div 元素的背景色为 红色</button>
<button>2.改变最后一个 div 元素的背景色为 红色</button>
<button>3.改变class不为 one 的所有 div 元素的背景色为 红色</button>
<button>4.改变索引值为偶数的 div 元素的背景色为 红色</button>
<button>5.改变索引值为奇数的 div 元素的背景色为 红色</button>
<button>6.改变索引值为大于 3 的 div 元素的背景色为 红色</button>
<button>7.改变索引值为等于 3 的 div 元素的背景色为 红色</button>
<button>8.改变索引值为小于 3 的 div 元素的背景色为 红色</button>
<button>9.改变所有的标题元素的背景色为 红色</button>
<script src="jquery-3.3.1.min.js"></script>
<script>
    /*
    1.改变第一个 div 元素的背景色为 红色
    2.改变最后一个 div 元素的背景色为 红色
    3.改变class不为 one 的所有 div 元素的背景色为 红色
    4.改变索引值为偶数的 div 元素的背景色为 红色
    5.改变索引值为奇数的 div 元素的背景色为 红色
    6.改变索引值为大于 3 的 div 元素的背景色为 红色
    7.改变索引值为等于 3 的 div 元素的背景色为 红色
    8.改变索引值为小于 3 的 div 元素的背景色为 红色
    9.改变所有的标题元素的背景色为 红色
     */
    $(function () {
        //1.改变第一个 div 元素的背景色为 红色
        $("button:nth-of-type(1)").click(function () {
            setRed($("div:first"))
        })
        $("button:nth-of-type(2)").click(function () {
            setRed($("div:last"))
        })
        $("button:nth-of-type(3)").click(function () {
            setRed($("div:not(.one)"))
        })
        $("button:nth-of-type(4)").click(function () {
            setRed($("div:even"))
        })
        $("button:nth-of-type(5)").click(function () {
            setRed($("div:odd"))
        })
        $("button:nth-of-type(6)").click(function () {
            setRed($("div:gt(3)"))
        })
        $("button:nth-of-type(7)").click(function () {
            setRed($("div:eq(3)"))
        })
        $("button:nth-of-type(8)").click(function () {
            setRed($("div:lt(3)"))
        })
        $("button:nth-of-type(9)").click(function () {
            setRed($(":header"))
        })

        //定义一个函数,将背景色设置为红色
        function setRed(dom) {
            dom.css({"background-color": "red"})
        }
    })
</script>
</body>
</html>
