# 第五天 数组和方法

> 作者:张大鹏
>
> 时间:2019年8月11日

## 001.回顾

- 1.循环结构
  - `for`:应用率高,固定次数循环
- 2.`break`:跳出循环
- 3.嵌套循环
- 4.数组
  - 是一种数据类型(引用类型)
  - 是一堆类型相同的数据的集合



## 002.案例:累加求和

> ```
> 累加和:9+99+999+....+9999999999
> ```

```java
package com.lxgzhw;

public class HomeWork01 {
    public static void main(String[] args) {
        //累加和:9+99+999+....+9999999999
        long sum = 0L;
        long[] arr = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 9999999999L};

        //计算数组的和
        for (int i = 0; i < arr.length; i++) {
            sum +=  arr[i];
        }
        System.out.println("9+99+999+....+9999999999 = " + sum);
    }
}
```



## 003.案例2

> 求1/1+1/2+1/3+....+1/n  (n>=2)的和

```java
package com.lxgzhw;

import java.util.Scanner;

public class HomeWork02 {
    public static void main(String[] args) {
        //求1/1+1/2+1/3+....+1/n  (n>=2)的和
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入n = ");
        int n = sc.nextInt();
        System.out.println();

        //开始计算
        double sum = 0;//总和
        for (double i = 0; i < n; i++) {
            sum += (1 / (i + 1));
        }
        System.out.println("1/1+1/2+1/3+....+1/n  (n>=2)的和为:" + sum);
    }
}
```

> 注意:`java`中只有同为`double`类型的值,计算的结果才为`double`类型



## 004.数组的复制

> 方法1

```java
package com.lxgzhw;

public class Array01 {
    public static void main(String[] args) {
        //数组的复制
        int[] arr = {11, 22, 33, 44};
        int[] targetArr = new int[4];

        //复制方法
        //参数:源数组,开始索引,目标数组,开始索引,要复制的元素个数
        System.arraycopy(arr, 0, targetArr, 0, 4);

        //遍历
        for (int i = 0; i < targetArr.length; i++) {
            System.out.print(targetArr[i] + "\t");
        }
    }
}
```

> 方法2

```java
package com.lxgzhw;

import java.util.Arrays;

public class Array02 {
    public static void main(String[] args) {
        //数组的复制:方法2

        //源数组
        int[] arr = {11, 22, 33, 44, 55};

        //目标数组
        //多了补0,少了截取
        int[] destArr = Arrays.copyOf(arr, 5);

        //打印测试
        for (int i = 0; i < destArr.length; i++) {
            System.out.print(destArr[i] + "\t");
        }
    }
}
```

  

## 005.数组的扩容

> 数组的长度理论上是不可变的,但是可以通过复制来扩容

- 案例

```java
package com.lxgzhw;

import java.util.Arrays;

public class Array03 {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33};
        //扩容
        arr = Arrays.copyOf(arr, arr.length + 1);
        //遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
```



## 006.案例3

> 求数组元素的最大值,并插入到数组最后一个元素的后面

```java
package com.lxgzhw;

import java.util.Arrays;

public class Array04 {
    public static void main(String[] args) {
        //求数组元素的最大值,并插入到数组最后一个元素的后面

        //定义一个数组,然后用随机数填充
        int[] arr = new int[5];
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }

        //对数组进行扩容
        arr = Arrays.copyOf(arr, len + 1);

        //求数组最大值,然后替换到最后一个元素
        int max = arr[0];
        for (int i = 0; i < len + 1; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        arr[len] = max;

        //遍历输出
        for (int i = 0; i < len + 1; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
```



## 007.数组的排序

- 排序是对数组施加的最常用的算法
- 一般分为升序和降序
- 常用的排序算法有:插入排序,冒泡排序,快速排序等

- 一般情况下,用交换次数来衡量排序算法的优劣

> Arrays.sort(arr)是专门用来做排序的

```java
package com.lxgzhw;

import java.util.Arrays;

public class Array05 {
    public static void main(String[] args) {

        //定义一个数组
        int[] arr = {11, 1, 2, 3, 333, 2, 22, 3222};
        //升序
        Arrays.sort(arr);

        //打印测试
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

    }
}
```



## 008.冒泡排序

> 从头依次开始取数与之后的数比较,将比较大的放后面

```java
package com.lxgzhw;

public class Array06 {
    public static void main(String[] args) {
        //冒泡排序
        int[] arr = {1, 1111, 1, 111, 11, 2, 2222, 22, 222};

        //冒泡排序就是从头依次比较,将较大的放在最上面
        //需要两层循环
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    //交换
                    int temp = 0;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        //遍历输出
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
```



## 009.练习

> 1.
>
> 声明整型数组arr,包含10个元素
>
> 遍历arr
>
> 给每个元素赋值为0-99的随机数
>
> 遍历输出数组
>
> 冒泡排序对arr进行升序
>
> 遍历输出排序后的数据



## 010.练习参考答案

```java
package com.lxgzhw;

public class Array07 {
    public static void main(String[] args) {
        //声明
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (100 * Math.random());
        }
        //遍历排序前的数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        //冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //比较
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        //遍历输出
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
```



## 011.方法

- 方法用于封装一段特定的逻辑功能
- 方法尽可能独立,只做一件事

- 方法可以被反复调用多次

- 减少代码重复,有利于代码维护



## 012.方法的定义

- 定义方法的五个要素
  - 修饰词
  - 返回值类型
    - 无返回值类型,写成`void`
    - 有返回值类型,写成具体的数据类型
  - 方法名
  - 参数列表
  - 方法体

```java
public static int[] bubbleSort(int[] arr){
    int[] newArr=new int[arr.length];
    //处理过程
    
    return newArr;//返回处理后的结果
}
```



## 013.封装猜数字小游戏

> 系统生成一个数字,让用户猜,猜对了程序结束

```java
package com.lxgzhw;

import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        //猜数字小游戏
        guessNum();
    }

    //封装猜数字的方法
    public static void guessNum() {
        Scanner sc = new Scanner(System.in);
        //系统随机生成一个数字
        int secretNum = (int) (Math.random() * 100);
        while (true) {
            //让用户猜测
            System.out.println("请输入1-100之间的数字:");
            int userGuessNum = sc.nextInt();

            if (userGuessNum > secretNum) {
                System.out.println("猜大了.");
            }
            if (userGuessNum < secretNum) {
                System.out.println("猜小了.");
            }

            //退出条件
            if (secretNum == userGuessNum) {
                System.out.println("恭喜您,猜对了!");
                break;
            }
        }


    }
}

```

