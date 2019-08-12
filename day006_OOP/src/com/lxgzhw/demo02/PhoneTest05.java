package com.lxgzhw.demo02;

public class PhoneTest05 {
    public static void main(String[] args) {
        //接收方法返回的PHone
        Phone iPhone = getPhone();
        //调用测试
        //当需要同包其他文件的方法是,需要指明文件名
        PhoneTest04.method(iPhone);
    }

    //返回Phone类型
    public static Phone getPhone() {
        Phone iPhone = new Phone();
        iPhone.brand = "苹果";
        iPhone.color = "土豪金";
        iPhone.price = 13999;
        return iPhone;
    }
}
