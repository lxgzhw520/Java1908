package com.lxgzhw.demo02;

public class PhoneTest03 {
    public static void main(String[] args) {
        Phone samSung = new Phone();
        samSung.brand = "SamSung";
        samSung.price = 5999;
        samSung.color = "black";

        //copy
        Phone iPhone = samSung;
        System.out.println(iPhone.brand);
        //set value
        iPhone.brand = "Apple";
        System.out.println("-------------------------------");
        System.out.println(samSung.brand);
        System.out.println(iPhone.brand);

        //The object can't be copy to other
        //We can see,tow object before is same one
    }
}
