package com.lxgzhw.demo01;

public final class Final01 {
    //用final修饰类,表示不可继承的

    //修饰方法表示不可被重写
    final void method() {
        System.out.println("最终方法....");
        //修饰局部变量
        final int NUM = 300;

        //错误写法,不可更改
        //NUM=3000;

        //使用
        System.out.println("不可更改的final值NUM=" + NUM);
    }

    public static void main(String[] args) {

        //修饰实例
        //表示其地址值不可变
        //注意:内容仍然可以改变
        final Final01 final01 = new Final01();
    }
}
