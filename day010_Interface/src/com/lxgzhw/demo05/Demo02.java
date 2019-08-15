package com.lxgzhw.demo05;

class A {
    void show() {
        System.out.println("AAA");
    }
}

interface B {
    void eat();
}

class C extends A implements B {
    @Override
    public void eat() {
        System.out.println("C在吃东西...");
    }
}

public class Demo02 {
    public static void main(String[] args) {
        //判断对象是否是什么的实例
        A a = new C();
        B b = new C();

        //判断a是不是C的实例
        //可以发现,a不仅是C的实例,也是A的实例
        System.out.println(a instanceof C);
        System.out.println(a instanceof A);

        //可以发现,b不仅是C的实例,同时也是B的实例
        System.out.println(b instanceof C);
        System.out.println(b instanceof B);
    }
}
