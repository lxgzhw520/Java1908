package com.lxgzhw.demo01;

public interface Interface03 {
    void methodA();

    //定义默认方法
    //默认方法可以不被重写
    default void methodB() {
        //默认方法可以有自己的方法体
        System.out.println("默认方法");
    }
}

class Test implements Interface03 {

    @Override
    public void methodA() {
        System.out.println("抽象方法");
    }
}

//测试
class Main {
    public static void main(String[] args) {
        Test test = new Test();
        //调用方法
        test.methodA();
        test.methodB();
    }
}