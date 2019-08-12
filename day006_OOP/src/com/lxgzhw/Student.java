package com.lxgzhw;

public class Student {
    //属性
    String name;
    int age;
    String address;

    public Student() {
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //学习方法
    void study() {
        System.out.println(this.name + "在学习...");
    }

    //打招呼方法
    void sayHi() {
        System.out.println("大家好,我叫" + this.name + ",今年" + this.age + "岁了.");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
