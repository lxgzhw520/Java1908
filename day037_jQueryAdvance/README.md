# `day037` `jQuery`进阶

> 作者: 张大鹏

## 001.显示和隐藏

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>显示和隐藏</title>
    <style>
        .box {
            width: 100px;
            height: 100px;
            background-color: gold;
        }
    </style>
</head>
<body>
<div class="box"></div>
<button>显示</button>
<button>隐藏</button>
<script src="jquery-3.3.1.min.js"></script>
<script>
    $(function () {
        $("button:nth-of-type(1)").click(function () {
            $(".box").show()
        })
        $("button:nth-of-type(2)").click(function () {
            $(".box").hide()
        })
    })
</script>
</body>
</html>
```



## 002.遍历

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>遍历</title>
</head>
<body>
<ul id="city">
    <li>北京</li>
    <li>上海</li>
    <li>天津</li>
    <li>重庆</li>
</ul>
<script src="jquery-3.3.1.min.js"></script>
<script>
    $(function () {
        let citys = $("#city")
        for (li of citys){
            alert($(li).html())
        }
    })
</script>
</body>
</html>
```



## 003.解绑事件

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>绑定事件和解绑</title>
</head>
<body>
<button>绑定</button>
<button>解绑</button>
<script src="jquery-3.3.1.min.js"></script>
<script>
    $(function () {
        $("button:nth-of-type(1)").on("click", function () {
            alert("绑定事件")
        })
        $("button:nth-of-type(2)").on("click", function () {
            alert("解绑事件")
            $("button:nth-of-type(1)").off("click");
        })
    })
</script>
</body>
</html>
```



## 004.广告显示和隐藏

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>广告</title>
    <style>
        #ad {
            width: 100%;
            height: 300px;
            background-color: gold;
            display: none;
        }
    </style>
</head>
<body>
<div id="ad">
    <h3>广告</h3>
</div>
<script src="jquery-3.3.1.min.js"></script>
<script>
    $(function () {
        //加载后3秒钟显示广告
        setTimeout(function () {
            $("#ad").slideDown()
        }, 3000)
        //加载后8秒钟停止广告
        setTimeout(function () {
            $("#ad").slideUp()
        }, 8000)
    })
</script>
</body>
</html>
```



