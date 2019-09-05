<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/3
  时间: 15:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>属性选择器</title>
    <style>
        div {
            border: 1px solid red;
            width: 200px;
            height: 100px;
            display: inline-block;
            margin: 20px 0;
        }

        button {
            margin: 20px;
        }
    </style>
</head>
<body>
<div title="test">title="test"</div>
<div title="test1111">title="test1111"</div>
<div title="2222test">title="2222test"</div>
<div title="te33333">title="te33333"</div>
<div title="44444est">title="44444est"</div>
<div title="es">title="es"</div>
<div title="es" id="eee">title="es" id="eee"</div>
<div id="eee1">id="eee1"</div>

<button>1.含有属性title 的div元素背景色为红色</button>
<button>2.属性title值等于test的div元素背景色为红色</button>
<button>3.属性title值不等于test的div元素(没有属性title的也将被选中)背景色为红色</button>
<button>4.属性title值 以te开始 的div元素背景色为红色</button>
<button>5.属性title值 以est结束 的div元素背景色为红色</button>
<button>6.属性title值 含有es的div元素背景色为红色</button>
<button>7.选取有属性id的div元素，然后在结果中选取属性title值含有“es”的 div 元素背景色为红色</button>
<script src="jquery-3.3.1.min.js"></script>
<script>
    /*
    1.含有属性title 的div元素背景色为红色
    2.属性title值等于test的div元素背景色为红色
    3.属性title值不等于test的div元素(没有属性title的也将被选中)背景色为红色
    4.属性title值 以te开始 的div元素背景色为红色
    5.属性title值 以est结束 的div元素背景色为红色
    6.属性title值 含有es的div元素背景色为红色
    7.选取有属性id的div元素，然后在结果中选取属性title值含有“es”的 div 元素背景色为红色
     */

    /*
    分析:翻阅文档可以发现
    1.[attribute*=value]匹配给定的属性是以包含某些值的元素
    2.[attribute$=value]匹配给定的属性是以某些值结尾的元素
    3.[attribute^=value]匹配给定的属性是以某些值开始的元素
    4.[attribute!=value]匹配所有不含有指定的属性，或者属性不等于特定值的元素。
    5.[attribute]匹配包含给定属性的元素
    6.[selector1][selector2][selectorN]复合属性选择器，需要同时满足多个条件时使用。
     */

    //代码实现
    $(function () {
        $("button:nth-of-type(1)").click(function () {
            //1.含有属性title 的div元素背景色为红色
            $("[title]").css({"background-color": "red"})
        })
        $("button:nth-of-type(2)").click(function () {
            //2.属性title值等于test的div元素背景色为红色
            $("[title=test]").css({"background-color": "red"})
        })
        $("button:nth-of-type(3)").click(function () {
            //3.属性title值不等于test的div元素(没有属性title的也将被选中)背景色为红色
            $("[title!=test]").css({"background-color": "red"})
        })
        $("button:nth-of-type(4)").click(function () {
            //4.属性title值 以te开始 的div元素背景色为红色
            $("[title^=te]").css({"background-color": "red"})
        })
        $("button:nth-of-type(5)").click(function () {
            //5.属性title值 以est结束 的div元素背景色为红色
            $("[title$=est]").css({"background-color": "red"})
        })
        $("button:nth-of-type(6)").click(function () {
            //6.属性title值 含有es的div元素背景色为红色
            $("[title*=est]").css({"background-color": "red"})
        })
        $("button:nth-of-type(7)").click(function () {
            //7.选取有属性id的div元素，
            //7.1然后在结果中选取属性title值含有“es”的 div 元素背景色为红色
            $("[id][title*=es]").css({"background": "red"})
        })

    })
</script>
</body>
</html>
