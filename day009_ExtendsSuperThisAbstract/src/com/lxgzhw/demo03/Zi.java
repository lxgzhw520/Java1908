package com.lxgzhw.demo03;

public class Zi extends Fu {
    int num=33;
    public void method(int num){
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(super.num);
    }
}
