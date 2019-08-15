package com.lxgzhw.demo02;

interface Interface01 {
    void methodA();
}

interface Interface02 {
    void methodB();
}

//测试类实现两个接口
class Test implements Interface01, Interface02 {

    @Override
    public void methodA() {
        System.out.println("第一个接口的方法");
    }

    @Override
    public void methodB() {
        System.out.println("第二个接口的方法");
    }
}
