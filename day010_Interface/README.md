# `day010` 接口和多态

> 作者: 张大鹏



## 001.接口概述

- 生活中的接口举例
  - 电源插座当中的电源接口
  - 电脑的`USB`接口
    - 只要符合`USB`规范的设备都可以使用
      - `U`盘
      - 硬盘
      - 打印机
      - 夜读灯
      - `USB`小风扇
- 接口就是一种公共的规范标准,只要符合规范标准,就可以大家通用



## 002.定义接口

- 接口是一种公共规范
- 接口时一种引用数据类型,最重要的内容就是其中的抽象方法
- 定义

```
public interface 接口名称{
	//接口内容
}
```

> 注意:接口生成的字节码文件还是`.class`

- 接口中可以包含的内容有`java8+`
  - 常量
  - 抽象方法
  - 默认方法
  - 静态方法
  - 私有方法 `java9+`
- 代码演示

```java
package com.lxgzhw.demo01;

public interface Interface01 {
    //定义一个抽象方法
    //接口当中的抽象方法,必须是两个固定的关键字
    //public abstract 所以可以省略
    public abstract void methodAbs();
    abstract void methodAbs2();
    public void methodAbs3();
    void methodAbs4();   
}
```



## 003.接口使用

- 使用步骤
  - 1.接口不能直接使用,必须有一个实现类来实现接口
    - 格式:`public class 类名称 impements 接口名称{}`
    - 注意:这里是`implements`而不是`extend`
  - 2.接口的实现类必须覆盖重写/实现接口中的所有抽象方法
  - 3.创建实现类的对象,进行使用
- 代码演示

```java
package com.lxgzhw.demo01;

public class Interface02 implements Interface01 {
    @Override
    public void methodAbs() {
        System.out.println("方法1");
    }

    @Override
    public void methodAbs2() {
        System.out.println("方法2");
    }

    @Override
    public void methodAbs3() {
        System.out.println("方法3");
    }

    @Override
    public void methodAbs4() {
        System.out.println("方法4");
    }

    //测试方法
    public static void main(String[] args) {
        Interface02 interface02 = new Interface02();

        //调用其方法
        interface02.methodAbs();
        interface02.methodAbs2();
        interface02.methodAbs3();
        interface02.methodAbs4();
    }
}
```



## 004.默认方法

- `jdk8`以上支持默认方法
  - 用来解决接口升级的问题
- 可以被接口实现类直接调用
- 可以被接口实现类重写覆盖
- 代码演示

```java
package com.lxgzhw.demo01;

public interface Interface03 {
    void methodA();

    //定义默认方法
    //默认方法可以不被重写
    default void methodB() {
        //默认方法可以有自己的方法体
        System.out.println("默认方法");
    }
}

class Test implements Interface03 {

    @Override
    public void methodA() {
        System.out.println("抽象方法");
    }
}

//测试
class Main {
    public static void main(String[] args) {
        Test test = new Test();
        //调用方法
        test.methodA();
        test.methodB();
    }
}
```



## 005.接口静态方法

> `jdk8+`支持静态方法

- 格式:
  - `public static 返回值类型 方法名称(参数列表){方法体}`
  - 就是将`abstract`或者`default`换成`static`即可
- 代码演示

```java
package com.lxgzhw.demo01;

public interface Interface04 {
    //定义抽象方法
    void methodA();
    //定义默认方法
    default void methodB(){
        System.out.println("默认方法");
    }
    //定义静态方法
    static void methodC(){
        System.out.println("静态方法");
    }
}

//实现类
class Test01 implements Interface04{
    @Override
    public void methodA() {
        System.out.println("抽象方法");
    }
    //测试
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        //调用
        test01.methodA();
        test01.methodB();
        //调用静态方法
        //接口的静态方法不能够通过实现类对象调用
        Interface04.methodC();
    }
}
```



## 006.接口常量

- 接口当中也可以定义成员变量,这个成员变量必须使用`public static final`修饰
- 从效果上看,这其实就是接口的常量
- 格式
  - `public static final 数据类型 常量名称=数据值;`
  - 可以省略三个关键字 `数据类型 常量名称=数据值;`
- 代码演示

```java
package com.lxgzhw.demo01;

public interface Interface05 {
    //省略了public static final
    //定义的实际上就是常量
    int NUM = 333;

    //定义抽象方法
    void methodA();

    //定义默认方法
    default void methodB() {
        System.out.println("默认方法");
    }

    //定义静态方法
    static void methodC() {
        System.out.println("静态方法");
    }
}

//测试2
class Test03 implements Interface05 {

    @Override
    public void methodA() {
        System.out.println("抽象方法");
    }

    //测试方法
    public static void main(String[] args) {
        //调用常量
        System.out.println(Interface05.NUM);
    }
}
```

> 注意事项:
>
> 1.常量名称用全大写,下划线分割



## 007.接口实现类的多实现

- 接口注意事项
  - 1.接口没有静态代码块
  - 2.接口没有构造方法
  - 3.一个类的直接父类是唯一的,但是一个类可以同时实现多个接口
  - 4.如果实现类所实现的多个接口当中,存在重复的抽象方法,那么只需要重写一次即可
  - 5.如果存在多个同名默认方法,需要重写该默认方法,解决冲突问题
  - 6.如果直接类方法与接口类默认方法重名,优先使用直接类方法
- 实现多个接口的代码演示

```java
package com.lxgzhw.demo02;

interface Interface01 {
    void methodA();
}

interface Interface02 {
    void methodB();
}

//测试类实现两个接口
class Test implements Interface01, Interface02 {

    @Override
    public void methodA() {
        System.out.println("第一个接口的方法");
    }

    @Override
    public void methodB() {
        System.out.println("第二个接口的方法");
    }
}
```

- 接口方法重名代码演示

```java
package com.lxgzhw.demo02;

interface Interface03 {
    void method();
}
interface Interface04 {
    void method();
}
//测试类
class Test02 implements Interface03,Interface04{
    @Override
    public void method() {
        System.out.println("重名方法只需实现一个.");
    }
}
```



## 008.接口本身多继承

- 接口是可以继承多个接口的
- 代码演示

```java
package com.lxgzhw.demo03;

interface D1 {
}

interface D2 {
}

//一个接口可以同时继承多个接口
interface D3 extends D1, D2 {
}
```

> 注意:这里是继承,而不是实现

- 注意
  - 如果多个接口的默认方法重复,需要重写该方法 



## 009.多态性

- 面向对象的三大特性
  - 封装性
  - 继承性
    - `extends`或者`implements`是多态性的前提
  - **多态性**
- 多态性的生活举例
  - 楚枫是一个老师,也是一个魔法师,更是一个召唤师
- 多态性的代码举例
  - 父类引用指向子类对象
  - 接口引用指向实现类对象
- 代码演示

> 父类引用指向子类对象

```java
package com.lxgzhw.demo04;

class A {
}

class B extends A {
    void show() {
        System.out.println("你好啊");
    }
}

public class Multi01 {
    public static void main(String[] args) {
        //父类引用指向子类
        A a = new B();
        //调用子类方法是,需要向下转型为子类
        ((B) a).show();
    }
} 
```

> 接口类指向实现类

```java
package com.lxgzhw.demo04;

interface A1 {
}

interface B1 {
}

interface C1 extends A1, B1 {
    void method();
}

//实现接口
class D1 implements C1 {

    @Override
    public void method() {
        System.out.println("接口多继承方法");
    }
}

//测试类
class Demo {
    public static void main(String[] args) {
        //接口指向实现类
        A1 a = new D1();
        B1 b = new D1();
        C1 c = new D1();

        //调用实现类的方法
        ((D1) a).method();
        ((D1) b).method();
        c.method();
    }
}
```

- 成员变量: 编译看左边,运行看左边
- 成员方法:编译看左边,运行看右边
  - 如果子类与父类同名方法,优先使用子类



## 010.使用多态的好处

- 无论右边`new`的时候换成哪个子类对象,等号左边调用方法都不会发生变化



## 011.向上转型

- 对象的向上转型,其实就是多态写法
  - `父类名称  对象名=new 子类名称()`
- 含义:右侧创建一个子类对象,把它当做父类来看待使用
- 举例
  - `Animal animal=new Cat()`
  - 创建了一只猫,当成动物来看待
- 注意:**向上转型,一定是安全的**
  - 原因:从小范围转换到大范围
  - 类似于基本数据类型的自动类型转换

- 代码演示

```java
package com.lxgzhw.demo05;

class Animal {
    void eat() {
        System.out.println("动物吃东西");
    }
}

class Cat extends Animal {
    void eat() {
        System.out.println("猫吃鱼");
    }
}

public class Demo01 {
    //向上转型
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();
    }
}
```



## 012.向下转型

- 一旦向上转型,就无法使用子类的特有方法
- 这时候就需要用到向下转型,还原为本类

- 代码演示

```java
package com.lxgzhw.demo05;

class Animal {
    void eat() {
        System.out.println("动物吃东西");
    }
}

class Cat extends Animal {
    void eat() {
        System.out.println("猫吃鱼");
    }

    //子类特有方法
    void catchMouse() {
        System.out.println("猫抓老鼠.");
    }
}

public class Demo01 {
    //向上转型
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();

        //使用向下转型调用子类特有方法
        ((Cat) animal).catchMouse();
    }
}
```

- 注意事项
  - 1.必须保证本来创建的就是猫,才能向下转型为猫
  - 2.如果不是,就会报错



## 013.`instanceof`用法

- 使用`instanceof`可以判断一个对象属于什么类的
- 源码演示

```java
package com.lxgzhw.demo05;

class A {
    void show() {
        System.out.println("AAA");
    }
}

interface B {
    void eat();
}

class C extends A implements B {
    @Override
    public void eat() {
        System.out.println("C在吃东西...");
    }
}

public class Demo02 {
    public static void main(String[] args) {
        //判断对象是否是什么的实例
        A a = new C();
        B b = new C();

        //判断a是不是C的实例
        //可以发现,a不仅是C的实例,也是A的实例
        System.out.println(a instanceof C);
        System.out.println(a instanceof A);

        //可以发现,b不仅是C的实例,同时也是B的实例
        System.out.println(b instanceof C);
        System.out.println(b instanceof B);
    }
}
```



## 014.综合案例

- `USB`接口,包含打开设备功能,关闭设备功能
- 笔记本类,包含开机功能,关机功能,使用`usb`的功能
- 鼠标类,实现`usb`接口,具备点击的方法
- 键盘类,实现`usb`接口,具备敲击的方法