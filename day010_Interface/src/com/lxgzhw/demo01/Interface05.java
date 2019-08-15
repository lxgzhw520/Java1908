package com.lxgzhw.demo01;

public interface Interface05 {
    //省略了public static final
    //定义的实际上就是常量
    int num = 333;

    //定义抽象方法
    void methodA();

    //定义默认方法
    default void methodB() {
        System.out.println("默认方法");
    }

    //定义静态方法
    static void methodC() {
        System.out.println("静态方法");
    }
}

//测试2
class Test03 implements Interface05 {

    @Override
    public void methodA() {
        System.out.println("抽象方法");
    }

    //测试方法
    public static void main(String[] args) {
        //调用常量
        System.out.println(Interface05.num);
    }
}
