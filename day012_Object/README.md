# day012 `Object`,常用`API`

> 作者:张大鹏



## 001.`equals`方法

- 比较其他对象与此对象是否相等
  - 基本数据类型,比较的是值
  - 引用数据类型,比较的是地址值
- 重写`equals`方法

```java
package com.lxgzhw.demo01;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
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
    //重写equals方法


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //测试
    public static void main(String[] args) {
        Person cuFeng = new Person("楚枫", 22);
        Person cuFeng1 = new Person("楚枫", 22);
        Person cuiCui = new Person("萃萃", 22);

        //比较
        System.out.println(cuFeng.equals(cuiCui));
        System.out.println(cuFeng.equals(cuFeng1));
    }
}
```



## 002.`Date`类

- 类 `Date` 表示特定的瞬间，精确到毫秒。 
  - `1000ms=1s`

```java
package com.lxgzhw.demo02;

import java.util.Date;

public class Date02 {
    public static void main(String[] args) {
        //构造方法
        Date date = new Date();
        //得到当前日期
        System.out.println(date);
        System.out.println("-------------------------------");


        //带参构造方法
        //将毫秒值转换为日期
        Date date1 = new Date(System.currentTimeMillis());
        System.out.println(date1);

        //常用方法 getTime() 当前时间毫秒值
        System.out.println(new Date().getTime());
        System.out.println(new Date(new Date().getTime()));
    }
}
```



## 003.`DateFormat`类

- DateFormat 是日期/时间格式化子类的抽象类，它以与语言无关的方式格式化并解析日期或时间。
- 日期/时间格式化子类（如 SimpleDateFormat）允许进行格式化（也就是日期 -> 文本）、解析（文本-> 日期）和标准化。
- 常用方法
  - `format`格式化日期
  - `parse`解析日期

- 代码实战

```java
package com.lxgzhw.demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//DateFormat类
public class Date03 {
    public static void main(String[] args) {
        //得到当前时间
        //年月日时分秒  yMdHms
        //对应的模式
        //yyyy年MM月dd日 HH:mm:ss
        //格式化的字符串传给的是构造方法
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

        //格式化只需要传一个Date实例即可
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
        System.out.println("-------------------------------");

        //解析的方法
        try {
            Date parse = simpleDateFormat.parse(format);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
```



## 004.`Calendar`类

- `Calendar` 类是一个抽象类，它为特定瞬间与一组诸如 
  `YEAR`、`MONTH`、`DAY_OF_MONTH`、`HOUR` 
  等 [`日历字段`](../../java/util/Calendar.html#fields)之间的转换提供了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法。
- 代码实战

```java
package com.lxgzhw.demo03;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calendar01 {
    public static void main(String[] args) {
        //获取日历类的实例
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println("-------------------------------");

        //年月日时分秒
        //YEAR MONTH DATE DAY_OF_MONTH HOUR MINUTE SECOND
        //get 返回给定的日历字段值
        int year = calendar.get(Calendar.YEAR);
        System.out.println("年份:" + year);
        System.out.println("-------------------------------");

        //set 设定给定的日历字段值
        calendar.set(Calendar.YEAR, 2020);
        year = calendar.get(Calendar.YEAR);
        System.out.println("修改后年份:" + year);
        System.out.println("-------------------------------");

        //打印日历
        System.out.println(calendar.toString());
        System.out.println("-------------------------------");

        //同时设置年月日
        calendar.set(2012, 5, 21);

        //增加或减少指定的字段
        calendar.add(Calendar.YEAR, -2);
        year = calendar.get(Calendar.YEAR);
        System.out.println("年份:" + year);
        System.out.println("-------------------------------");


        //把日历对象转换为日期对象
        Date time = calendar.getTime();
        //格式化
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
        System.out.println(format);

    }
}
```



## 005.`System`类

```java
package com.lxgzhw.demo04;

public class System01 {
    public static void main(String[] args) {
        //获取当前时间的毫秒值
        System.out.println(System.currentTimeMillis());

        //数组复制方法
        int[] arr = {11, 22, 33};
        int[] dest = new int[3];
        System.arraycopy(arr, 0, dest, 0, 3);
        //遍历数组
        for (int i = 0; i < dest.length; i++) {
            System.out.print(dest[i] + "\t");
        }
    }
}
```



## 006.`StringBuilder`类

- 一个可变的字符序列。此类提供一个与 `StringBuffer` 兼容的 API，但不保证同步。该类被设计用作 
  `StringBuffer` 
  的一个简易替换，用在字符串缓冲区被单个线程使用的时候（这种情况很普遍）。如果可能，建议优先采用该类，因为在大多数实现中，它比 
  `StringBuffer` 要快。
- 在 `StringBuilder` 上的主要操作是 `append` 和 `insert` 
  方法，可重载这些方法，以接受任意类型的数据。每个方法都能有效地将给定的数据转换成字符串，然后将该字符串的字符追加或插入到字符串生成器中。`append` 
  方法始终将这些字符添加到生成器的末端；而 `insert` 方法则在指定的点添加字符。
- 使用背景
  - 字符串拼接会有多个字符串,占用空间多,效率低下

```java
package com.lxgzhw.demo05;

public class String01 {
    public static void main(String[] args) {
        //字符串缓冲区,可以提供字符串的操作效率
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello");
        stringBuffer.append(',');
        stringBuffer.append(97);
        stringBuffer.append(33.33);
        stringBuffer.append("你哈哈,java~");

        //打印
        System.out.println(stringBuffer.toString());
        System.out.println("-------------------------------");
        //在hello的后面插入数据
        int index = stringBuffer.indexOf("o");
        index += 1;
        stringBuffer.insert(index, ",world!!!\t");
        System.out.println(stringBuffer.toString());
        System.out.println("-------------------------------");
    }
}
```



## 007.包装类

- 每一种基本类型都有自己对应的包装类
- 装箱:`把基本类型的数据转换为对应的包装类对象`
- 拆箱:`将包装类对象转换为基本类型`
- 代码实战

```java
package com.lxgzhw.demo05;

public class Integer01 {
    public static void main(String[] args) {
        //装箱:基本类型->包装类型
        //拆箱:包装类型->基本类型
        Integer integer = new Integer(1);
        System.out.println("装箱:" + integer);
        int i = integer;
        System.out.println("自动拆箱:" + i);
    }
}
```



## 008.其他类型转字符串

```java
package com.lxgzhw.demo05;

public class String02 {
    public static void main(String[] args) {
        //基本类型和字符串之间的转换
        //其他类型转字符串
        int i = 111;
        String s = String.valueOf(i);
        System.out.println(s);
        System.out.println("-------------------------------");
        
        
        double i1=11.111;
        String s1 = String.valueOf(i1);
        
        boolean i2=true;
        String s2 = String.valueOf(i2);
        
        float i3=333.333F;
        String s3 = String.valueOf(i3);
    }
}
```



## 009.字符串转基本类型

```java
package com.lxgzhw.demo05;

public class String03 {
    public static void main(String[] args) {

        //字符串转整数
        String s1 = "1";
        int i = Integer.parseInt(s1);
        System.out.println(i);
        System.out.println("-------------------------------");

        //字符串转浮点数
        String s2 = "11.11";
        double i2 = Double.parseDouble(s2);
        System.out.println(i2);
        System.out.println("-------------------------------");


        //字符串转布尔值
        String s3 = "true";
        boolean i3 = Boolean.parseBoolean(s3);
        System.out.println(i3);
        System.out.println("-------------------------------");

    }
}
```

