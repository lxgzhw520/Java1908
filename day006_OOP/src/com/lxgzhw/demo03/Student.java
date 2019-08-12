package com.lxgzhw.demo03;

public class Student {
    private String name;//姓名
    private int age;//年龄
    private boolean male;//是不是男的

    //特殊情况,boolean类型的get方法要写is
    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
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
