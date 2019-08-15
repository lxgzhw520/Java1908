package com.lxgzhw.demo02;

public class Outer {
    int outNum=33;
    String name="变量名相同.";
    class Inner{
        int innerNum=33;
        String name="变量名相同.";
        //使用重名变量,就近原则
        void userVariable(){
            System.out.println("就近原则:"+name);
            System.out.println("使用外部类的同名变量:"+new Outer().name);
        }
    }
}
