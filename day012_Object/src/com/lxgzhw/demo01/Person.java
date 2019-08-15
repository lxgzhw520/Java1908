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
