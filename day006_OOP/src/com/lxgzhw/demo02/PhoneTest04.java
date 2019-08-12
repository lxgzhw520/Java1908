package com.lxgzhw.demo02;

public class PhoneTest04 {
    public static void main(String[] args) {
        Phone iPhone = new Phone();
        iPhone.brand = "苹果";
        iPhone.price = 8889;
        iPhone.color = "玫瑰金";

        //将手机对象作为参数传给方法
        method(iPhone);
    }

    //使用自定义的类作为参数
    public static void method(Phone p) {
        System.out.println("-------------------------------");
        System.out.println("品牌:" + p.brand);
        System.out.println("颜色:" + p.color);
        System.out.println("价格:" + p.price);
        System.out.println("-------------------------------");
    }
}
