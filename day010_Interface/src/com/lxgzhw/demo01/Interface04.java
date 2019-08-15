package com.lxgzhw.demo01;

public interface Interface04 {
    //定义抽象方法
    void methodA();
    //定义默认方法
    default void methodB(){
        System.out.println("默认方法");
    }
    //定义静态方法
    static void methodC(){
        System.out.println("静态方法");
    }
}

//实现类
class Test01 implements Interface04{
    @Override
    public void methodA() {
        System.out.println("抽象方法");
    }
    //测试
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        //调用
        test01.methodA();
        test01.methodB();
        //调用静态方法
        //接口的静态方法不能够通过实现类对象调用
        Interface04.methodC();
    }
}