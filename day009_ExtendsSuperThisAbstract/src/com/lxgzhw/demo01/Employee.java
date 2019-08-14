package com.lxgzhw.demo01;

public class Employee {
    private String name;
    private int age;


    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee(){
        System.out.println("构造方法执行...");
    }
    public static void show(){
        System.out.println("员工类的show方法");
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
