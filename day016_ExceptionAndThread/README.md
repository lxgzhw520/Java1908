# `day016`异常和多线程

> 作者:张大鹏

## 001.捕获异常

```java
package com.lxgzhw.Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Throwable:
    1.Exception 程序员能处理的错误
    2.Error 程序员不能处理的错误
 */
public class Demo01 {
    public static void main(String[] args) {
        //捕获异常
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse("2019-9999");
        } catch (ParseException e) {
            System.out.println("不支持的日期格式,请检查.");
        }
    }
}
```



## 002.抛出异常

```java
package com.lxgzhw.Exception;

public class Demo02 {
    public static void main(String[] args) {
        int[] arr = new int[3];
        getElement(arr, 3);
        System.out.println("-------------------------------");
        getElement(null, 3);
    }

    private static int getElement(int[] arr, int i) {
        //合法性检验
        //1.数组不能为空
        if (arr == null) {
            System.out.println("不能为空.");
            //抛出异常
            //异常会中断程序的执行
            throw new NullPointerException("传递的数组值是null");
        }
        //2.索引不能超过数组范围
        if (i < 0 || i > arr.length - 1) {
            System.out.println("索引越界了.");
            throw new ArrayIndexOutOfBoundsException("传递的索引超过了数组的范围");
        }

        //正常情况
        int num = arr[i];
        return num;
    }
}
```



## 003.`null`异常抛出

```java
package com.lxgzhw.Exception;

import java.util.Objects;

public class Demo03 {
    public static void main(String[] args) {
        //查看引用类型是否为null的专用方法
        method(null);
    }

    private static void method(Object o) {
        //这个方法会抛出异常,终止程序
        Objects.requireNonNull(o, "传递的对象值是null");
    }
}
```



