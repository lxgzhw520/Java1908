package com.lxgzhw.demo02;

public class Student {
    private int id;//学号
    private String name;
    private int age;
    static String room;//所在教室
    private static int idCounter=0;//学号计数器

    public Student() {
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        //先自增后执行
        this.id=++idCounter;
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
