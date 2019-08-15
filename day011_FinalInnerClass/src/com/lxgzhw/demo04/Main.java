package com.lxgzhw.demo04;

public class Main {
    public static void main(String[] args) {
        //如果接口的实现类,或者父类的子类,只需要使用唯一的一次
        //定义
        Interface01 interface01 = new Interface01() {
            @Override
            public void method() {
                System.out.println("接口方法");
            }
        };

        //调用方法
        interface01.method();
    }
}
