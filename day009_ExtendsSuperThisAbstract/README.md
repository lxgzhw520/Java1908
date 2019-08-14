# `day009` 继承,super,this和抽象类

> 作者:张大鹏



## 001.面向对象特性

- 封装性
- 继承性
  - 是多态的前提,没有继承,就没有多态
- 多态性



## 002.继承

- 主要解决的问题是:**共性提取**

- 被继承的类叫`父类/基类/超类`
- 继承的类叫`子类/派生类`
- 继承关系当中特点:
  - 1.子类可以拥有父类的"内容"
  - 2.子类还可以拥有自己专有的`新内容`
- 子类可以被当成是父类,例如`子类是讲师,父类是员工,那么讲师也可以看成是员工`



## 003.继承的定义

- 父类的定义
  - `public class 父类名称{}`
- 子类的定义
  - `public class 子类名称 extends 父类名称{}`



## 004.同名变量的访问

- 直接写,局部变量
- `this`,本类成员变量
- `super`,父类的成员变量

> 父类

```java
package com.lxgzhw.demo03;

public class Fu {
    int num=20;
    public void  method(){
        System.out.println(num);
    }
}
```

> 子类

```java
package com.lxgzhw.demo03;

public class Zi extends Fu {
    int num=33;
    public void method(int num){
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(super.num);
    }
}
```

> 测试类

```java
package com.lxgzhw.demo03;

public class Demo01 {
    public static void main(String[] args) {
        Zi zi = new Zi();
        zi.method(55);
    }
}
```



## 005.方法的重写

- 在继承关系中,方法名称一样,参数列表也一样,叫做重写
  - 也叫方法的覆盖,覆写
- 和重载的区别
  - 重载:方法名称一样,参数列表不一样
- 注意事项
  - 1.必须保证父子类的方法名称相同,参数列表也相同
  - 2.对重写方法最好加上`@Override`,进行安全检测
  - 3.子类方法的返回值必须小于等于父类方法的返回值范围
  - 4.子类方法的权限必须大于等于父类方法的权限修饰符
    - `public > protected > default > private`
- 典型案例

> 父类

```java
package com.lxgzhw.demo04;

public class Phone {
    public void call(){
        System.out.println("打电话");
    }
    public void send(){
        System.out.println("发短信");
    }
    public void show(){
        System.out.println("显示号码");
    }
}
```

> 子类

```java
package com.lxgzhw.demo04;

public class NewPhone extends Phone {
    @Override
    public void show(){
        //调用父类的功能
        super.show();
        //添加新的功能
        System.out.println("显示姓名");
        System.out.println("显示头像");
    }
}
```

> 测试类

```java
package com.lxgzhw.demo04;

public class Demo {
    public static void main(String[] args) {
        NewPhone newPhone = new NewPhone();
        newPhone.show();
    }
}
```



## 006.构造方法的访问特点

- 子类默认会调用父类的构造方法 `super()`
- 可以通过`super()`重写父类构造方法
- `super()`所在的语句必须是子类的第一句

- `super`关键字的用法有三种
  - 在子类的成员方法中,访问父类的成员变量
  - 访问父类的成员方法
  - 访问父类的构造方法
- `this`关键字的用法也有三种
  - 在本类的成员方法中,访问本类的成员变量
  - 在本类的成员方法中,访问另一个成员方法
  - 在本类的构造方法中,访问另一个构造方法



## 007.Java继承的三个特点

- 1.`Java`语言是单继承的
  - 一个类的直接父类只能有唯一的一个
- 2.`Java`语言可以多级继承
- 3.一个父类可以拥有很多个子类



## 008.抽象的概念

- 非具体的就是抽象
  - 图形是一种抽象
    - 可以求三角形的面积,但是没法求图形的面积,因为图形是一种抽象
  - 三角形,正方形,圆形则是一种具体
  - 动物是一种抽象
    - 狗吃骨头,但是无法确定动物吃什么,因为动物是一种抽象
  - 狗,猫等动物则是一种具体

- 定义一个抽象的类

```java 
package com.lxgzhw.demo06;

public abstract class Animal {
    public abstract void eat();
}
```

> 注意:
>
> 1.抽象类用abstract定义
>
> 2.抽象方法,需要用abstract修饰
>
> 3.抽象方法不能写实现,也就是没有`{}`大括号
>
> 4.抽象类中可以定义普通方法
>
> 5.不能直接创建抽象类对象
>
> 6.子类继承抽象类必须重写实现其抽象方法

- 继承抽象类

```java
package com.lxgzhw.demo06;

public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼...");
    }
}
```

- 测试继承类

```java
package com.lxgzhw.demo06;

public class Demo01 {
    public static void main(String[] args) {
        //错误写法
        //Animal animal = new Animal();
        Cat cat = new Cat();
        cat.eat();
        System.out.println("-------------------------------");       
    }
}
```



## 009.练习1

> 发红包: 
>
> 用面对对象的方法完成以下案例:
>
> 群主发红包,三个普通成员接收,然后分别打印群主和三个普通成员的姓名和红包余额

> 参考答案

> 用户类

```java
package com.lxgzhw.demo07;

public class User {
    private String name;//姓名
    private double money;//余额

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public User() {
    }

    public User(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
```

> 群主类

```java
package com.lxgzhw.demo07;

import java.util.ArrayList;

//群主类
public class Manager extends User {
    public Manager() {
    }

    public Manager(String name, double money) {
        super(name, money);
    }
    //发红包的方法
    public ArrayList<Double> send(double totalMoney,double count){
        //存储若干个红包的集合
        ArrayList<Double> redPackageList = new ArrayList<>();

        //首先看一下群主自己有多少钱
        double leftMoney=super.getMoney();

        //如果余额不足,直接返回
        if (leftMoney<totalMoney){
            System.out.println("余额不足");
            return redPackageList;
        }
        //扣钱
        leftMoney-=totalMoney;
        super.setMoney(leftMoney);

        //发红包需要拼接拆分为count份
        double avg=totalMoney/count;

        //把红包放到集合中
        for (int i = 0; i < count; i++) {
            redPackageList.add(avg);
        }
        //打印红包
        System.out.println("-------------------------------");
        System.out.println("红包:");
        System.out.println(redPackageList);
        System.out.println("-------------------------------");

        //返回红包集合
        return redPackageList;
    }
}
```

> 普通成员类

```java
package com.lxgzhw.demo07;

import java.util.ArrayList;
import java.util.Random;

//普通成员
public class Member extends User {
    public Member() {
    }

    public Member(String name, double money) {
        super(name, money);
    }
    //收红包的方法
    public void receive(ArrayList<Double> list){
        //随机从红包中抽取一个
        Random r=new Random();
        int i = r.nextInt(list.size());
        //根据索引,从集合中删除元素,并得到被删除的红包
        //Double redPackageMoney = list.get(i);
        Double redPackageMoney = list.remove(i);
        double money = super.getMoney();
        money+=redPackageMoney;
        super.setMoney(money);
    }
}
```

> 入口类

```java
package com.lxgzhw.demo07;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("群主", 10000);
        Member cuFeng = new Member("楚枫", 100);
        Member cuiCui = new Member("萃萃", 100);
        Member daHuang = new Member("大黄", 0);

        //群主发红包
        ArrayList<Double> redPackage = manager.send(100, 3);
        //普通成员收红包
        cuFeng.receive(redPackage);
        cuiCui.receive(redPackage);
        daHuang.receive(redPackage);

        //查看余额
        System.out.println("群主:" + manager.getMoney());
        System.out.println("楚枫:" + cuFeng.getMoney());
        System.out.println("萃萃:" + cuiCui.getMoney());
        System.out.println("大黄:" + daHuang.getMoney());
    }
}
```

