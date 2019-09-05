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
