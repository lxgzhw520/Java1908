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
