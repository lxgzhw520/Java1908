package com.lxgzhw.demo04.ObjectStream;

import java.io.Serializable;

public class Person implements Serializable {
    //想要被写入的自定义类型必须实现Serializable接口
    //防止修改代码带来的冲突报错的解决方法
    //写一个固定的序列化id,这个是固定写法
    private static final long serialVersionUID = 1L;
    //如果有什么内容不想被序列化,用transient关键字

    //常规存储 姓名,年龄
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
