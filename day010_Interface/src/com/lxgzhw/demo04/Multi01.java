package com.lxgzhw.demo04;

class A {
}

class B extends A {
    void show() {
        System.out.println("你好啊");
    }
}

public class Multi01 {
    public static void main(String[] args) {
        //父类引用指向子类
        A a = new B();
        //调用子类方法是,需要向下转型为子类
        ((B) a).show();
    }
}
