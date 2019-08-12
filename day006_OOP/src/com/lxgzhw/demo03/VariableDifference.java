package com.lxgzhw.demo03;


public class VariableDifference {
    String name = "楚风";//成员变量

    public void methodA() {
        int num1 = 22;//局部变量
        //局部变量只有方法自己可以使用
        System.out.println(num1);
    }

    public void methodB() {
        //成员变量所有方法都可以使用
        System.out.println(this.name);
    }

    //主方法测试
    public static void main(String[] args) {
        VariableDifference v = new VariableDifference();
        v.methodA();
        v.methodB();
    }
}
