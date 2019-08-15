package com.lxgzhw.demo04;

interface A1 {
}

interface B1 {
}

interface C1 extends A1, B1 {
    void method();
}

//实现接口
class D1 implements C1 {

    @Override
    public void method() {
        System.out.println("接口多继承方法");
    }
}

//测试类
class Demo {
    public static void main(String[] args) {
        //接口指向实现类
        A1 a = new D1();
        B1 b = new D1();
        C1 c = new D1();

        //调用实现类的方法
        ((D1) a).method();
        ((D1) b).method();
        c.method();
    }
}