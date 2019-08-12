package com.lxgzhw.demo02;

public class PhoneTest02 {
    public static void main(String[] args) {
        Phone samSung = new Phone();
        samSung.brand = "SamSung";
        samSung.price = 5999;
        samSung.color = "black";

        //use function
        System.out.println("-------------------------------");
        samSung.call("Silla");
        samSung.sendMessage();

        //use variable
        System.out.println("-------------------------------");
        System.out.println(samSung.brand);
        System.out.println(samSung.price);
        System.out.println(samSung.color);
    }
}
