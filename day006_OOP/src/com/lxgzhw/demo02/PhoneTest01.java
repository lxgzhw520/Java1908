package com.lxgzhw.demo02;

public class PhoneTest01 {
    public static void main(String[] args) {
        //Create a object by Phone
        Phone iphone8 = new Phone();

        //set value
        iphone8.brand = "iPhone";
        iphone8.color = "Gold";
        iphone8.price = 13888;

        System.out.println(iphone8.brand);
        System.out.println(iphone8.color);
        System.out.println(iphone8.price);
        //use function
        System.out.println("-------------------------------");
        iphone8.call("Jobs");
        iphone8.sendMessage();
    }
}
