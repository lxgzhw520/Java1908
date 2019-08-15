package com.lxgzhw.demo03;

public class Demo01 {
    public static void main(String[] args) {

        //调用方法
        testClass();

    }

    //定义一个方法,方法中有一个类,就是局部内部类
    static void testClass() {
        class Test {
            String name;

            public Test(String name) {
                this.name = name;
            }
        }

        Test test = new Test("测试");
        System.out.println("方法内部的类:" + test.name);
    }
}
