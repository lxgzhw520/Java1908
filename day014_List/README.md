# `day014` List, Set

> 作者:张大鹏



## 001.`List`集合

- 特点:查询快,增删满

```java
package com.lxgzhw.List;

import java.util.ArrayList;
import java.util.List;

/*
List集合的特点:
    1.有序
    2.有索引
    3.可以重复
List集合常用方法:
    1.add(索引,元素) 增加元素到集合
    2.get(索引) 根据索引获取元素
    3.remove(索引) 移除指定索引的元素
    4.set(索引,元素) 替换指定位置的元素
 */
public class Demo01 {
    public static void main(String[] args) {
        //创建List集合
        //多态
        List<String> strings = new ArrayList<>();
        strings.add("楚枫");
        strings.add("萃萃");
        strings.add("大黄");

        //获取
        System.out.println(strings.get(1));
        //移除
        strings.remove(1);
        //替换
        strings.set(1, "哈哈哈");
        System.out.println(strings);
        System.out.println("-------------------------------");

        //遍历
        for (String string : strings) {
            System.out.println(string);
        }

    }
}
```



## 002.`LinkedList`集合

```java
package com.lxgzhw.List;

import java.util.LinkedList;

/*
LinkedList集合的特点:
    1.底层是链表,查询慢,增删快
    2.包含了大量操作首尾元素的方法
    3.不能使用多态
 */
public class Demo02 {
    public static void main(String[] args) {
        //添加方法
        linkedListAdd();
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        //删除方法
        linkedLIstRemove();
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        //其他方法
        linkedListEmpty();
    }

    //判断是否为空
    private static void linkedListEmpty() {
        //不为空就删除第一个元素
        LinkedList<String> strings = new LinkedList<>();
        if (!strings.isEmpty()) {
            System.out.println("不是空的...");
            strings.removeFirst();
        }
        System.out.println("是空的...");
    }

    //LinkedList集合的删除方法
    private static void linkedLIstRemove() {
        //1.removeFirst()
        //2.removeLast()
        //3.pop()
        //4.remove()
        LinkedList<String> strings = new LinkedList<>();
        strings.add("楚枫");
        strings.add("萃萃");
        strings.add("大黄");
        strings.push("第一个");
        strings.push("第一个");
        System.out.println(strings);
        System.out.println("-------------------------------");
        //pop removeFirst 删除第一个元素
        strings.removeFirst();
        strings.pop();
        System.out.println(strings);
        System.out.println("-------------------------------");
        strings.addLast("最后一个");
        System.out.println(strings);
        System.out.println("-------------------------------");
        //removeLast删除最后一个
        strings.removeLast();
        System.out.println(strings);
        System.out.println("-------------------------------");

    }

    //LinkedList增加方法
    private static void linkedListAdd() {
        //1.addFirst(元素) 将元素添加到开头
        //2.addLast(元素) 将元素添加到结尾
        //3.push(元素) 将元素添加到堆栈(开头)
        //总结: 开头 addFirst  push  结尾 add addLast
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        System.out.println(integers);
        System.out.println("-------------------------------");
        System.out.println("添加到结尾:");
        integers.addLast(33);
        integers.add(3333);
        System.out.println(integers);
        integers.push(333);
        System.out.println("-------------------------------");
        System.out.println("添加到开头");
        System.out.println(integers);
        integers.addFirst(33333);
        System.out.println(integers);
        System.out.println("-------------------------------");

    }
}
```



## 003.`Set`集合

```java
package com.lxgzhw.Set;

import java.util.HashSet;

/*
Set集合的特点:
    1.不允许重复
    2.没有索引

HashSet的特点:
    1.不重复
    2.没有索引
    3.无序
    4.底层是哈希表结构,查询非常快
 */
public class Demo01 {
    public static void main(String[] args) {
        //定义集合,自动去重
        HashSet<Integer> integers = new HashSet<>();
        integers.add(11);
        integers.add(11);
        integers.add(133);
        integers.add(133333);
        //遍历集合
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
```

- 自动去重

```java
package com.lxgzhw.Set;

import java.util.HashSet;

public class Demo02 {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        strings.add("abd");
        strings.add("abd");
        strings.add("重地");
        strings.add("通话");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
```



## 004.`Set`存储自定义对象

> `Person`对象

```java
package com.lxgzhw.Set;

import java.util.Objects;

public class Person {
    private String name;
     private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
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
}
```

> 存储对象,自动去重

```java
package com.lxgzhw.Set;

import java.util.HashSet;

/*
HashSet存储自定义类型:
    1.要求该类型重写hash方法和equals方法
 */
public class Demo03 {
    public static void main(String[] args) {
        //要求存储不同名字和年龄的对象
        HashSet<Person> people = new HashSet<>();
        people.add(new Person("楚枫", 23));
        people.add(new Person("楚枫", 23));
        people.add(new Person("萃萃", 23));
        people.add(new Person("萃萃", 23));
        people.add(new Person("大黄", 23));
        //遍历
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
```



## 005.可变参数

```java
package com.lxgzhw.VarArgs;

/*
可变参数:
    1.接收任意长度的参数
    2.语法,在类型的后面加上...
    3.本质是一个数组
 */
public class Demo01 {
    public static void main(String[] args) {
        //测试
        System.out.println(add(1, 2));
        System.out.println(add(1, 2, 3));
        System.out.println(add(1, 2, 3, 4));
        System.out.println(add(1, 2, 3, 4, 5));
    }

    //定义一个方法,实现任意个数的整数相加
    static int add(int... args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += args[i];
        }
        return sum;
    }
}
```



## 006.`Collections`添加,排序,打乱

```java
package com.lxgzhw.Collections;

import java.util.ArrayList;
import java.util.Collections;

/*
Collections集合工具类常用方法:
    1.addAll(集合,要添加的元素...) 向集合添加可变参数个元素
    2.shuffle(list集合) 打乱list集合的顺序
 */
public class Demo01 {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        //添加方法
        Collections.addAll(intList, 11, 22, 33, 44, 55, 66);
        //打印
        System.out.println(intList);
        //打乱顺序
        Collections.shuffle(intList);
        //再次打印
        System.out.println(intList);
        //排序
        Collections.sort(intList);
        //再次打印
        System.out.println(intList);
    }
}
```



## 007.`Collections`对自定义对象排序

> 对象

```java
package com.lxgzhw.VarArgs;

public class Person {
    private String name;
    private int age;

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

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

> 排序

```java
package com.lxgzhw.VarArgs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo02 {
    public static void main(String[] args) {
        //创建集合
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("楚枫", 22));
        people.add(new Person("萃萃", 18));
        people.add(new Person("大黄", 300));

        //按照年龄升序 o1-o2
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        //打印
        for (Person person : people) {
            System.out.println(person);
        }
        System.out.println("-------------------------------");
        //按照年龄降序 o2-o1
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        for (Person person : people) {
            System.out.println(person);
        }

    }
}
```

