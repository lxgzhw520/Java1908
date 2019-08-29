package com.lxgzhw.demo04.Super;

public class Man extends Human {
    //重写父类sayHi
    @Override
    public void sayHi() {
        System.out.println("嗨,我是子类Man");
    }

    //定义接口函数方法:见面
    public void meet(Meet m) {
        m.meet();
    }

    //使用接口函数
    public void show() {
        //子类中调用父类的方法
        meet(super::sayHi);
    }

    //测试
    public static void main(String[] args) {
        new Man().show();
    }
}
