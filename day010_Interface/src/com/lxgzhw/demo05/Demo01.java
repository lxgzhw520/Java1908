package com.lxgzhw.demo05;

class Animal {
    void eat() {
        System.out.println("动物吃东西");
    }
}

class Cat extends Animal {
    void eat() {
        System.out.println("猫吃鱼");
    }

    //子类特有方法
    void catchMouse() {
        System.out.println("猫抓老鼠.");
    }
}

public class Demo01 {
    //向上转型
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();

        //使用向下转型调用子类特有方法
        ((Cat) animal).catchMouse();
    }
}
