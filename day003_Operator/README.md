# 第三天:运算符+分支结构



## 001.回顾

- 1.变量
  - 用来存储程序运行过程中需要用到的数据
  - 两种定义方式
    - 先声明,后赋值 `int a;a=33;`
    - 声明并方式 `int a=33;`
  - 变量的命名规范
    - 只能由数字,字母,下划线组成,不能以数字开头
    - 驼峰命名法
    - 帕斯卡命名法
- 2.基本数据类型
  - `boolean` 布尔型,1个字节,`true`,`false`
  - `byte`
  - `short`
  - `int` 整型,4个字节
  - `long` 长整型,8个字节,`5L`,`10000000000L`
  - `float` 
  - `double` 浮点型,8个字节
  - `char` 字符型,2个字节
    - 特殊符号需要`\`转义
    - 本质上存储的是`Unicode`编码
- 3.基本数据类型间的转换
  - 1.两种方式
    - 自动/隐式类型转换 `小->大`
    - 强制类型转换 `大->小`
      - 有可能溢出或丢失精度
  - 2.两点规则
    - 整型直接量可以直接赋值给`byte`,`short`,`char`,但是不能超出范围
    - `byte`和`short`的运算需要先转换为`int`类型再运算
- 4.`Scanner`的用法
  - 1.导入依赖的包 `import java.util.Scanner;`
  - 2.创建录入对象 `Scanner sc=new Scanner(System.in);`
  - 3.录入用户输入的数据 `int age=sc.nextInt();`



## 002.算术运算符

- 加 `+`
- 减 `-`
- 乘 `*`
- 除 `/`
- 取余 `%`

```java
package com.lxgzhw;

public class Operator01 {
    public static void main(String[] args) {
        int num1 = 11;
        int num2 = 22;

        System.out.println("加法:" + (num1 + num2));
        System.out.println("减法:" + (num1 - num2));
        System.out.println("乘法:" + (num1 * num2));
        System.out.println("除法:" + (num1 / num2));
        //取余,除不尽的,结果就是自己
        System.out.println("取余:" + (num1 % num2));
        System.out.println("取余:" + (num1 % 33));
        System.out.println("取余:" + (num1 % 55));
    }
}
```



## 003.自增自减运算符

- 自增运算符 `++`
- 自减运算符 `--`

> 运算符在前表示先执行后加
>
> 运算符在后表示先加后执行

- 案例:自增运算符单独使用的情况

```java
package com.lxgzhw;

public class Operator02 {
    public static void main(String[] args) {
        //单独用的时候,++在前在后都一样
        int num = 4;
        num++;//相当于num+=1
        System.out.println(num);

        int num1 = 5;
        ++num;//先执行后加
        System.out.println(num1);
    }
}
```

- 案例:自增运算符参与其他运算的情况

```java
package com.lxgzhw;

public class Operator03 {
    public static void main(String[] args) {
        //参与其他运算的时候
        int a = 33, b = 55;
        
        //这里先执行 c的赋值,然后再执行的a的自增
        //所以,c是原本的a的值,而a是自增后的值
        int c = a++;
        
        //这里先执行b的自增,然后执行d的赋值
        //所以d和b都是自增后的值
        int d = ++b;
        System.out.println("a=" + a);//34
        System.out.println("b=" + b);//56
        System.out.println("c=" + c);//33
        System.out.println("d=" + d);//56
    }
}
```

- 案例:在输出的时候自增运算符被使用

```java
package com.lxgzhw;

public class Operator04 {
    public static void main(String[] args) {
        int a = 3, b = 3;

        //总结:被使用的时候,++在后,得到的是未自增之前的值
        //++在前,得到的是自增后的值
        //一句话:++在前先自增后执行,++在后,先执行后自增
        System.out.println(a++);//3
        System.out.println(a);//4
        System.out.println(++b);//4
        System.out.println(b);//4
    }
}
```



## 004.练习

> 1.
>
> 输出5%3  输出9%3  输出3%6

> 2.
>
> 声明整型变量a并赋值为5,a++,输出a
>
> 声明整型变量b并赋值为5,b++,输出b

> 3.
>
> 声明整型变量c并赋值为5
>
> 声明整型变量d并赋值为c++,输出c,输出d
>
> 声明整型变量e并赋值为5
>
> 声明整型变量f并赋值为++e,输出e,输出f

> 4.
>
> 声明整型变量g和h,并分别都赋值为5
>
> 输出g--,输出g
>
> 输出--h,输出h



## 005.练习参考答案

```java
package com.lxgzhw;

public class Practice01 {
    public static void main(String[] args) {
        //1
        System.out.println("5%3=" + (5 % 3));
        System.out.println("9%3=" + (9 % 3));
        System.out.println("3%6=" + (3 % 6));

        System.out.println("-------------------------------");
        //2
        int a = 5;
        a++;
        System.out.println("a=" + a);
        int b = 5;
        ++b;
        System.out.println("b=" + b);

        System.out.println("-------------------------------");
        //3
        int c = 5;
        int d = c++;
        System.out.println("c=" + c);
        System.out.println("d=" + d);

        int e = 5;
        int f = ++e;
        System.out.println("e=" + e);
        System.out.println("f=" + f);

        //4
        System.out.println("-------------------------------");
        int g = 5, h = 5;
        System.out.println(g--);
        System.out.println(g);
        System.out.println(--h);
        System.out.println(h);
    }
}
```

> 总结:表达式中,++和--在前,先计算,再执行;在后,先执行,再计算.



## 006.关系运算符

- 大于 `>`
- 小于 `<`
- 等于 `==`
- 大于等于 `>=`
- 小于等于 `<=`
- 不等于 `!=`

> 注意:比较运算符所在的表达式得到的结果是一个布尔值
>
> 关系成立则为true,关系不成立则为false

- 案例:比较年龄

```java
package com.lxgzhw;

import java.util.Scanner;

public class Operator05 {
    public static void main(String[] args) {
        //比较年龄
        int myAge = 25;
        //判断我的年龄和用户年龄之间的关系
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的年龄:");
        int userAge = sc.nextInt();
        if (myAge > userAge) {
            System.out.println("我的年龄大于您的年龄.");
        } else if (myAge < userAge) {
            System.out.println("我的年龄小于您的年龄.");
        } else {
            System.out.println("我的年龄等于您的年龄.");
        }
    }
}
```



## 007.逻辑运算符

> 当需要多个条件控制同一件事的时候,就需要用到关系运算符
>
> 例如:
>
> 成绩>=60% 并且 出勤率 >= 80%

- 1.`&&` 逻辑与:表示并且的关系,左右两边需要同时成立
- 2.`||` 逻辑或:表示或的关系,左右两边有一个成立即可
- 3.`!` 逻辑非:表示非的关系,把真的变成假的,把假的变成真的



## 008.案例1:判断年龄

```java
package com.lxgzhw;

import java.util.Scanner;

public class Operator06 {
    public static void main(String[] args) {
        //判断年龄是否在18到50之间
        System.out.println("请输入您的年龄:");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        if (age > 18 && age < 50) {
            System.out.println("年龄在18-50之间");
        } else {
            System.out.println("年龄在18-50之间");
        }
    }
}
```



## 009.案例2:判断是否为闰年

```java
package com.lxgzhw;

import java.util.Scanner;

public class Operator07 {
    public static void main(String[] args) {
        //判断是否为闰年
        System.out.println("请输入年份:");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        //能被4整除且不能100整除 或能够被400整除
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println(year + "是闰年");
        } else {
            System.out.println(year + "不是闰年");
        }
    }
}
```



## 010.赋值运算符

- 1.正常赋值 `=`
- 2.加等于 `+=`
- 3.减等于 `-=`
- 4.乘等于 `*=`
- 5.除等于 `/=`
- 6.取余等于 `%=`

> 注意:赋值运算符带强制转换的功能

- 案例:自动强制转换

```java
package com.lxgzhw;

public class Operator08 {
    public static void main(String[] args) {
        short num1 = 3;
        //这里相等于  num1=(short)(num1+33);
        num1 += 33;
        System.out.println("num1=" + num1);
        short num2 = (short) (num1 + 33);
        System.out.println("num2=" + num2);
    }
}
```



## 011.字符串拼接运算符

- `+`
  - 1.若两边都为数字,则为加法运算符
  - 2.若两边出现了字符串,则为拼接运算符
- 拼接运算符的特点
  - 会将非字符串自动转换为字符串,然后与字符串拼接在一起输出



## 012.三目运算符

> 语法: boolean?为真执行的语句:为假执行的语句

- 案例:简单的三目运算

```java
package com.lxgzhw;

public class Operator09 {
    public static void main(String[] args) {
        //三目运算符
        boolean flag = true;
        System.out.println(flag ? "真的很大" : "真的不大");
    }
}
```



## 013.柜台收银程序

```java
package com.lxgzhw;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        //柜台收银程序
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入单价:");
        double unitPrice = sc.nextDouble();
        System.out.println("请输入数量:");
        double amount = sc.nextDouble();


        //计算总价(单价*数量)
        double totalPrice = unitPrice * amount;
        System.out.println("总价为:" + totalPrice);

        //打折(八折)
        totalPrice *= 0.8;
        System.out.println("折后价格为:" + totalPrice);

        System.out.println("请输入支付金额:");
        double money = sc.nextDouble();
        //计算找零(支付金额-总价)
        double change = money - totalPrice;
        System.out.println("您支付了:" + money + "元");
        System.out.println("找您" + change + "元");

    }
}
```



## 014.常见的程序结构

- 1.顺序结构:从上往下执行
- 2.分支结构:根据不同的判断执行不同的逻辑
- 3.循环结构:重复的执行同一段代码



## 015.`if`结构

> 满足条件就执行代码块

```java
package com.lxgzhw;

import java.util.Scanner;

public class Structure01 {
    public static void main(String[] args) {
        //录入分数,如果大于等于60分则输出及格
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入分数:");
        double score = sc.nextDouble();
        if (score >= 60) {
            System.out.println("及格了.");
        }
    }
}
```



## 016. `if...else`结构

> 满足条件执行代码块,不满足条件执行另一个代码块

```java
package com.lxgzhw;

import java.util.Scanner;

public class Structure02 {
    public static void main(String[] args) {
        //成年人可以进网吧,未成年人进制进网吧
        System.out.println("请输入年龄:");

        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        if (age >= 18) {
            System.out.println("成年人可以进网吧.");
        } else {
            System.out.println("未成年人禁止进网吧.");
        }
    }
}
```



## 017.作业

> 1.
>
> 录入两个数,输出其中最大的数

> 2.
>
> 录入三个数,将三个数按照升序排序



## 018.参考答案

> 第一题

```java
package com.lxgzhw;

import java.util.Scanner;

public class HomeWork01 {
    public static void main(String[] args) {
        //录入两个数,输出最大值
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入第一个数:");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个数:");
        int num2 = sc.nextInt();

        int max;
        if (num1 > num2) {
            max = num1;
        } else {
            max = num2;
        }

        //输出
        System.out.println("您输入的两个数分别为:" + num1 + "," + num2);
        System.out.println("其中最大的数为:" + max);
    }
}
```

> 第二题

```java
package com.lxgzhw;

import java.util.Scanner;

public class HomeWork02 {
    public static void main(String[] args) {
        //录入三个数,按从小到大排序然后输出
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入第一个数:");
        int max = sc.nextInt();
        System.out.println("请输入第二个数:");
        int mid = sc.nextInt();
        System.out.println("请输入第三个数:");
        int min = sc.nextInt();


        //打印测试
        System.out.println("您输入的三个数分别为:" + max + ", " + mid + ", " + min);
        System.out.println("从小到大依次为:");
        //现在有三个数,需要进行升序

        int temp;
        //第一次比较:交换 确保max> mid
        if (max < mid) {
            temp = mid;
            mid = max;
            max = temp;
        }
        //第二次比较: 确保max> min
        if (max < min) {
            temp = min;
            min = max;
            max = temp;
        }
        //第三次比较: 确保mid> min
        if (mid < min) {
            temp = mid;
            mid = min;
            min = temp;
        }
        System.out.print(min + ", ");
        System.out.print(mid + ", ");
        System.out.print(max + ", ");
    }

}
```

