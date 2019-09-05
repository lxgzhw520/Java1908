# `day036` `jQuery`基础

> 作者: 张大鹏

## 001.`jQuery`入门

```html
<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/3
  时间: 14:44
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jQuery快速入门</title>
</head>
<body>

<%--1.引入jQuery--%>
<script src="jquery-3.3.1.min.js"></script>
<%--2.使用jQuery--%>
<script>
    $(function () {
        alert("我终于会用jQuery了...")
    })
</script>
</body>
</html>
```



## 002.修改元素内容

```html
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
```



## 003.绑定点击事件

```html
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
```



## 004.基本选择器

```html
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
```



## 005.属性选择器

```html
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
```



## 006.层级选择器

```html
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
```



## 007.基本过滤器

```html
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
```



## 008.表单过滤器

```html
<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/3
  时间: 16:05
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单过滤器</title>
    <style>
        button {
            margin: 10px;
        }
    </style>
</head>
<body>
<form action="">
    <input type="text" value="可用1">
    <input type="text" value="可用2">
    <input type="text" value="不可用1" disabled>
    <input type="text" value="不可用2" disabled>
    <h3>复选框</h3>
    <input type="checkbox" name="i" value="选项1">选项1
    <input type="checkbox" name="i" value="选项2">选项2
    <input type="checkbox" name="i" value="选项3">选项3
    <input type="checkbox" name="i" value="选项4">选项4
    <h3>下拉框</h3>
    <select name="select" multiple>
        <option value="选项1">选项1</option>
        <option value="选项2">选项2</option>
        <option value="选项3">选项3</option>
        <option value="选项4">选项4</option>
    </select>
</form>
<button>1.利用 jQuery 对象的 val() 方法改变表单内可用 input 元素的值</button>
<button>2.利用 jQuery 对象的 val() 方法改变表单内不可用 input 元素的值</button>
<button>3.利用 jQuery 对象的 length 属性获取复选框选中的个数</button>
<button>4.利用 jQuery 对象的 length 属性获取下拉框选中的个数</button>
<script src="jquery-3.3.1.min.js"></script>
<script>
    /*
    1.利用 jQuery 对象的 val() 方法改变表单内可用 input 元素的值
    2.利用 jQuery 对象的 val() 方法改变表单内不可用 input 元素的值
    3.利用 jQuery 对象的 length 属性获取复选框选中的个数
    4.利用 jQuery 对象的 length 属性获取下拉框选中的个数
     */
    $(function () {
        $("button:nth-of-type(1)").click(function () {
            $("input:enabled").val("可用的input")
        })
        $("button:nth-of-type(2)").click(function () {
            $("input:disabled").val("不可用的input")
        })
        $("button:nth-of-type(3)").click(function () {
            let $len = $("[type=checkbox]:checked").length
            alert("长度是:" + $len)
        })
        $("button:nth-of-type(4)").click(function () {
            let $len = $("select>option:selected").length
            alert("被选中的个数:" + $len)
        })
    })
</script>
</body>
</html>
```



## 009:案例1:隔行换色

```jsp
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
```



## 010.案例2:全选全不选

```jsp
<%--
  编辑器: IntelliJ IDEA.
  作者: 18010
  日期: 2019/9/3
  时间: 16:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全选和全不选</title>
</head>
<body>
<table id="tab1" border="1" width="800" align="center">
    <tr>
        <td colspan="5"><input type="button" value="删除"></td>
    </tr>
    <tr>
        <th><input type="checkbox" class="selectAll">全选</th>
        <th>分类ID</th>
        <th>分类名称</th>
        <th>分类描述</th>
        <th>操作</th>
    </tr>
    <tr>
        <td><input type="checkbox" class="itemSelect"></td>
        <td>1</td>
        <td>手机数码</td>
        <td>手机数码类商品</td>
        <td><a href="">修改</a>|<a href="">删除</a></td>
    </tr>
    <tr>
        <td><input type="checkbox" class="itemSelect"></td>
        <td>2</td>
        <td>电脑办公</td>
        <td>电脑办公类商品</td>
        <td><a href="">修改</a>|<a href="">删除</a></td>
    </tr>
    <tr>
        <td><input type="checkbox" class="itemSelect"></td>
        <td>3</td>
        <td>鞋靴箱包</td>
        <td>鞋靴箱包类商品</td>
        <td><a href="">修改</a>|<a href="">删除</a></td>
    </tr>
    <tr>
        <td><input type="checkbox" class="itemSelect"></td>
        <td>4</td>
        <td>家居饰品</td>
        <td>家居饰品类商品</td>
        <td><a href="">修改</a>|<a href="">删除</a></td>
    </tr>
</table>
<script src="jquery-3.3.1.min.js"></script>
<script>
    /*
    分析:
    1.如果表格中的所有.itemSelect选中,则.selectAll选中
        1.1 获取.itemSelect的元素长度
        1.2 获取.itemSelect:selected的长度
            1.如果等于元素长度,说明全选
     */
    $(function () {
        let $all = $(".selectAll")
        let $item = $(".itemSelect")
        //1.当点击全选的时候,实现全选全不选
        $all.click(function () {
            $item.prop({checked: $all.prop("checked")})
        })

        //2.当点击单选的时候,如果全部选择,要实现全选
        $item.click(function () {
            let $selectedLength = 0;
            let $len = $item.length
            $selectedLength = $(".itemSelect:checked").length
            if ($len == $selectedLength) {
                $(".selectAll").prop({checked: true})
            }else {
                $(".selectAll").prop({checked: false})
            }
        })
    })
</script>
</body>
</html>
```

