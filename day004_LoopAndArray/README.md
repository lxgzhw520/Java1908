# 第四天 循环



## 001.回顾

- 1.分支结构
- 2.循环:反复执行一段相同或相似的代码
- 3.循环三要素
  - 1.循环变量的初始化
  - 2.循环的条件
  - 3.循环变量的改变
- 4.循环结构
  - `while`:先判断,后执行,有可能一次都不执行
  - `do...while`:先执行,后判断,至少执行一次



## 案例1:计算个人所得税

```java
package com.lxgzhw;

public class HomeWork01 {
    public static void main(String[] args) {
        //个人所得税
        double salary = 10000.0;//工资
        double taxSalary = salary - 3500;//记税工资
        double tax = 0.0;//税

        /*
         * 已知税率:
         * 1500 3
         * 4500 10
         * 9000 20
         * 35000 25
         * 55000 30
         * 80000 35
         * 80000+ 45
         */
        if (taxSalary <= 0) {
            //不纳税
            tax = 0.0;
        } else if (taxSalary <= 1500) {
            tax = taxSalary * 0.03;
        } else if (taxSalary <= 4500) {
            tax = taxSalary * 0.1;
        } else if (taxSalary <= 9000) {
            tax = taxSalary * 0.2;
        } else if (taxSalary <= 35000) {
            tax = taxSalary * 0.25;
        } else if (taxSalary <= 55000) {
            tax = taxSalary * 0.3;
        } else if (taxSalary <= 80000) {
            tax = taxSalary * 0.35;
        } else if (taxSalary > 80000) {
            tax = taxSalary * 0.45;
        } else {
            tax = 0;
        }

        //扣税后工资
        double finalSalary = taxSalary - tax;
        System.out.println("税后工资为:" + finalSalary);
    }
}
```



## 案例2:根据年份和月份计算天数

```java
package com.lxgzhw;

import java.util.Scanner;

public class HomeWork02 {
    public static void main(String[] args) {
        //根据年份 计算天数
        //1 3 5 7 8 10 12  --->>> 31天
        //4 6 9 11         --->>> 30天
        //2                --->>> 28天/29天
        Scanner sc = new Scanner(System.in);
        //录入年份和月份
        System.out.println("请输入年份:");
        int year = sc.nextInt();
        //根据年份和月份计算天数
        System.out.println("请输入月份:");
        int month = sc.nextInt();

        int days = 0;//用来记录天数

        // 计算天数
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                //判断是否为闰年
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    //闰年2月29天
                    days = 29;
                } else {
                    days = 28;
                }
        }


        //输出结果
        System.out.println(year + "年" + month + "月的天数为:" + days + "天");
    }
}
```



## 003.`for`语句

```
for(表达式1;表达式2;表达式3){
	代码块
}
```

- 案例:循环打印10次 `行动是成功的阶梯`

```java
package com.lxgzhw;

public class ForDemo01 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("行动是成功的阶梯:" + (i + 1));
        }
    }
}
```

> 执行流程:  表达式1>表达式2>表达式3>语句块  以上不断循环,直到表达式2变为false



## 004.案例:求1加到100的和

```java
package com.lxgzhw;

public class ForDemo02 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            sum += i;
        }
        System.out.println("1加到100的和为:" + sum);
    }
}
```



## 005.`while`语句

```
定义条件变量
while(条件){
	语句块
	条件变量改变
}
```

- 案例:求1加到100的和

```java
package com.lxgzhw;

public class WhileDemo01 {
    public static void main(String[] args) {
        int sum = 0, i = 0;
        while (i < 101) {
            sum += i;
            i++;
        }
        System.out.println("1加到100的和为:" + sum);
    }
}
```



## 006.终止循环

- `break`,将该关键字放在需要终止的位置即可



- 案例:求1+2+3....不断往上加,加到多少的时候,和大于333

```java
package com.lxgzhw;

public class WhileDemo02 {
    public static void main(String[] args) {
        //求1+2+3....不断往上加,加到多少的时候,和大于333
        int i = 0, sum = 0;
        while (true) {
            sum += i;
            //退出条件
            if (sum > 333) {
                break;
            }
            i++;
        }
        System.out.println("当加到" + i + "的时候,和大于333.值为:" + sum);
    }
}
```



## 007.跳过循环

- `continue`:跳过本次循环
- 用的比较少



- 案例:求1到100之间,除了能被3整除的数之外的所有数之和

```java
package com.lxgzhw;

public class ForDemo03 {
    public static void main(String[] args) {
        //案例:求1到100之间,除了能被3整除的数之外的所有数之和
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            if (i % 3 == 0) {
                continue;
            }
            sum += i;
        }
        System.out.println("1到100之间,除了能被3整除的数之外的所有数之和为:" + sum);

        //验证
        int sum1 = 0;
        for (int i = 0; i < 101; i++) {
            if (i % 3 == 0) {
                sum1 += i;
            }
        }
        System.out.println("1到100之间,除了能被3整除的数之外的所有数之和为:" + (5050 - sum1));
    }
}
```



## 008.案例:随机加法答题器

> 提示:随机数的生成方法 (int)(Math.random()*100)

```java
package com.lxgzhw;

import java.util.Scanner;

public class Addition {
    public static void main(String[] args) {
        //随机加法答题器
        int score = 0;//得分
        // 答对1题加10分
        // 连续答对多少题就加多少分
        int continueNum = 0;//连续答对次数
        int spendTime = 0;//消耗时间(秒)
        int startTime = 0;//答题开始时间
        int endTime = 0;//答题结束时间
        int systemStartTime = 0;//系统开始时间
        int systemEndTime = 0;//系统结束时间
        int problemNum = 0;//题目数量
        Scanner sc = new Scanner(System.in);//录入对象
        //两个数的加法
        int num1 = 0;//第一个数
        int num2 = 0;//第二个数
        int result = 0;//结果
        int userResult = 0;//用户输入的结果

        //选择题目数量
        System.out.println("请选择题目的数量(10/20/30/50):");
        problemNum = sc.nextInt();
        //记录系统开始时间
        systemStartTime = (int) System.currentTimeMillis();
        for (int i = 0; i < problemNum; i++) {
            num1 = (int) (Math.random() * 10000);
            num2 = (int) (Math.random() * 10000);

            //开始出题
            System.out.println("题目" + (i + 1) + ":");
            System.out.println(num1 + " + " + num2 + " =");
            //答题开始时间
            startTime = (int) System.currentTimeMillis();
            result = num1 + num2;
            userResult = sc.nextInt();
            endTime = (int) System.currentTimeMillis();
            //消耗时间
            spendTime = (endTime - startTime) / 10000;
            System.out.println("本次答题时间为:" + spendTime + "秒");
            System.out.println("您的答案是:" + userResult);
            System.out.println("正确答案是:" + result);
            //判断是否回答正确
            if (userResult == result) {
                System.out.println("恭喜您回答正确.");
                score += 10;//本来的分
                score += continueNum;//连续答对得分
                continueNum++;
            } else {
                System.out.println("很遗憾,回答错误!");
                continueNum = 0;
            }

            //退出条件
//            break;

        }
        //记录系统结束时间
        systemEndTime = (int) System.currentTimeMillis();
        System.out.println("本次答题总共消耗时间为:" + ((systemEndTime - systemStartTime) / 10000) + "秒.");
    }
}
```



## 009.案例:九九乘法表

```java
package com.lxgzhw;

public class ForDemo04 {
    public static void main(String[] args) {
        //九九乘法表
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " x " + i + " = " + (i * j) + "\t");
            }
            System.out.println("");
        }
    }
}
```



## 010.程序

程序=算法+数据结构

- 1.算法:解决问题的流程/步骤(顺序,分支,循环)
- 2.数据结构:将数据按照某种特定的结构来保存
  - 良好的数据结构决定良好的算法



## 011.数组

- 1.是一种数据类型(引用类型)
- 2.相同数据类型元素的集合
- 3.数组的定义

```java
//声明一个整型数字
int a;

//声明一个整型的数组
int[] a;

//声明一个double类型的数组
double[] scores;

//声明char类型的数组
char[] sexs;
//给引用类型赋值必须要使用关键字new
int[] arr=new int[10];//中括号里面的数字表示元素个数

//声明包含26个元素的boolean数组
boolean[] arr=new boolean[26];//默认值是false
```

- 4.给数组赋值`数组的初始化`

```java
//给整型数组赋值
int[] ages={22,33,32,23,25,22,33,31,38}

//声明和赋值分开的方法
int[] arr;
arr={1,2};//编译错误 这是错误的写法
arr=new int[]{11,22,313};//正确的写法
```

- 5.数组的访问,通过下标/索引访问数组中的元素

```java
int[] arr={11,22,33};

//获取数组的长度
int arrLength=arr.lengh

//修改数组元素的值
//给第二个数赋值为100
arr[1]=100;

//下标是从0开始,最大到(数组的长度-1)
int endNum=arr[arr.length-1];//最后一个元素

//第一个元素
int startNum=arr[0];

//第二个元素
int secondNum=arr[1];

//第三个元素
int thirdNum=arr[2];
```

- 6.数组的遍历

```java
package com.lxgzhw;

public class ArrayDemo01 {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = new int[10];

        //遍历数组并赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        //打印数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```



## 012.练习

> 1.
>
> 声明整型数组
>
> `arr1`,包含10个元素
>
> `arr2`,直接初始化为2,5,8,9
>
> `arr3`,先new再直接初始化为2,5,8,9
>
> `arr`,元素1为100,元素2为200,元素3为300,输出数字的长度,输出最后一个值

> 2.
>
> 创建类MaxOfArray
>
> 新建数组arr,包含10个元素
>
> 让每个元素位0-99之间的随机数
>
> 输出每个元素的值



## 013.练习参考答案

> 第一题

```java
package com.lxgzhw;

public class ArrayDemo02 {
    public static void main(String[] args) {
        //1
        int[] arr1 = new int[10];
        //2
        int[] arr2 = {2, 5, 8, 9};
        int[] arr3;
        arr3 = new int[]{2, 5, 8, 9};

        //3
        int[] arr = new int[3];
        arr[0] = 100;
        arr[1] = 200;
        arr[2] = 300;
        System.out.println("数组长度为:" + arr.length);
        System.out.println("数组的最后一个元素的值为:" + arr[arr.length - 1]);
    }
}
```



> 第二题

```java
package com.lxgzhw;

public class MaxOfArray {
    public static void main(String[] args) {
        //定义数组
        int[] arr = new int[10];

        //随机赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        //打印输出
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
```



## 014.求数组元素的最大值

```java
package com.lxgzhw;

//求数组元素的最大值
public class MaxOfArray {
    public static void main(String[] args) {
        //定义数组
        int[] arr = new int[10];

        //随机赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        //打印输出
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        //从数组中找到最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println();
        System.out.println("数组中的最大值为:" + max);
    }
}
```

