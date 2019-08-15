package com.lxgzhw.demo01;

public class Interface02 implements Interface01 {
    @Override
    public void methodAbs() {
        System.out.println("方法1");
    }

    @Override
    public void methodAbs2() {
        System.out.println("方法2");
    }

    @Override
    public void methodAbs3() {
        System.out.println("方法3");
    }

    @Override
    public void methodAbs4() {
        System.out.println("方法4");
    }

    //测试方法
    public static void main(String[] args) {
        Interface02 interface02 = new Interface02();

        //调用其方法
        interface02.methodAbs();
        interface02.methodAbs2();
        interface02.methodAbs3();
        interface02.methodAbs4();
    }
}
