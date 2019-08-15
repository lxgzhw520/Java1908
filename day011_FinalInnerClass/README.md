# `day011` 内部类和`final`

> 作者: 张大鹏



## 001.`final`关键字

- 最终的,代表不可变的

- 常见的四种用法,可以用来修饰

  - 1.类
  - 2.方法
  - 3.局部变量
  - 4.成员变量

  

> 修饰一个类

- 表示不可继承的
- 格式: `public final class 类名{}`
- 代码演示

```java
package com.lxgzhw.demo01;

public final class Final01 {
    //用final修饰类,表示不可继承的
}
```



> 修饰一个方法

- 表示不可重写

- 代码演示

```java
package com.lxgzhw.demo01;

public final class Final01 {
    //用final修饰类,表示不可继承的
    
    //修饰方法表示不可被重写
    final void method(){
        System.out.println("最终方法....");
    }
}
```



> 修饰局部变量

- 表示为最终变量,即就是常量

- 代码演示

```java
package com.lxgzhw.demo01;

public final class Final01 {
    //用final修饰类,表示不可继承的

    //修饰方法表示不可被重写
    final void method() {
        System.out.println("最终方法....");
        //修饰局部变量
        final int NUM = 300;

        //错误写法,不可更改
        //NUM=3000;

        //使用
        System.out.println("不可更改的final值NUM=" + NUM);
    }
}
```



> 修饰实例

- 表示地址值不可变
- 代码演示

```java
package com.lxgzhw.demo01;

public final class Final01 {
    //用final修饰类,表示不可继承的

    //修饰方法表示不可被重写
    final void method() {
        System.out.println("最终方法....");
        //修饰局部变量
        final int NUM = 300;

        //错误写法,不可更改
        //NUM=3000;

        //使用
        System.out.println("不可更改的final值NUM=" + NUM);
    }

    public static void main(String[] args) {

        //修饰实例
        //表示其地址值不可变
        //注意:内容仍然可以改变
        final Final01 final01 = new Final01();
    }
}
```



## 002.权限修饰符

- `java`中有四种权限修饰符
  - `public` 
  - `protected` 
  - `deafault`
  - `private`

- 类与类直接的关系
  - 同一个包 
    - 可以访问 `public` `protected` `default`修饰的内容
  - 同一个类
    - 可以访问 `public` `protected` `default` `private`修饰的内容
  - 不同包不同类
    - 子类
      - 可以访问 `public` `protected`
    - 非子类
      - 可以访问 `public`



## 003.内部类

- 一个类是用来描述一个事物的
- 如果一个事物包含另一个事物,那么就是一个类中包含另一个类
- 这种被包含的类,叫做内部类,可以简单的看出是类的嵌套
- 内部类分为
  - 成员内部类
  - 局部内部类(包含匿名内部类)



## 004.成员内部类

- 直接定义在一个类的顶层的新类,叫做成员内部类
- 成员内部类不能有`static`修饰的静态方法
- 代码演示

> 定义成员内部类

```java
package com.lxgzhw.demo02;

//身体
public class Body {
    private String name;
    private int age;

    //内部类 心脏
    class Heart{
        //内部类的方法
        void beat(){
            System.out.println("心脏跳动.");
            //调用外部类的变量
            System.out.println("我叫"+name);
        }
        
    }

    public Body() {
    }

    public Body(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Body{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```



## 005.使用成员内部类

- 1.间接访问: 通过外部类的方法调用内部类的方法

```java
package com.lxgzhw.demo02;

public class Demo01 {
    public static void main(String[] args) {
        Body body = new Body();
        body.useHeart();
    }
}
```

- 2.直接访问:`外部类名称.内部类名称 对象名=new 外部类名称().new 内部类名称()`

```java
package com.lxgzhw.demo02;

public class Demo02 {
    public static void main(String[] args) {
        Body.Heart heart = new Body().new Heart();
        heart.beat();
    }
}
```



## 006.内部类的同名变量访问

- 代码演示

```java
package com.lxgzhw.demo02;

public class Outer {
    int outNum=33;
    String name="变量名相同.";
    class Inner{
        int innerNum=33;
        String name="变量名相同.";
        //使用重名变量,就近原则
        void userVariable(){
            System.out.println("就近原则:"+name);
            System.out.println("使用外部类的同名变量:"+new Outer().name);
        }
    }
}
```



## 007.局部内部类

- 如果一个类定义在方法内部,则这个类就是局部内部类
- 局部内部类只能在方法内部使用
- 如果要访问所在方法的局部变量,那么这个局部变量必须是有效final的
  - `JDK8+可以省略final`
  - 跟生命周期有关
    - `new`出来的对象在堆内存中
    - 局部变量是跟着方法走的,在栈内存中
    - 方法运行结束以后,立刻出栈,局部变量会立刻消失
    - `new`出来的对象会持续在堆内存中,直到垃圾回收
    - 所以,有可能局部变量消失了,而对象还在,而对象需要引用局部变量
    - 局部变量添加`final`关键字解决这个问题
- 代码演示

```java
package com.lxgzhw.demo03;

public class Demo01 {
    public static void main(String[] args) {

        //调用方法
        testClass();

    }

    //定义一个方法,方法中有一个类,就是局部内部类
    static void testClass() {
        class Test {
            String name;

            public Test(String name) {
                this.name = name;
            }
        }

        Test test = new Test("测试");
        System.out.println("方法内部的类:" + test.name);
    }
}
```



## 008.匿名内部类

- 如果接口实现类,或者子类,只需要使用唯一的一次,就推荐使用匿名内部类
- 格式: `接口名称 对象名=new 接口名称(){}`
- 代码演示

```java
package com.lxgzhw.demo04;

public class Main {
    public static void main(String[] args) {
        //如果接口的实现类,或者父类的子类,只需要使用唯一的一次
        //定义
        Interface01 interface01 = new Interface01() {
            @Override
            public void method() {
                System.out.println("接口方法");
            }
        };

        //调用方法
        interface01.method();
    }
}
```



