package com.lxgzhw.demo04;

public class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    void sayHi(String name) {
        System.out.println("你好" + name + ",我的名字是:" + this.name);
    }
}
