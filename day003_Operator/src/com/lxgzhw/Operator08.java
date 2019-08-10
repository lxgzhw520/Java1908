package com.lxgzhw;

public class Operator08 {
    public static void main(String[] args) {
        short num1 = 3;
        //这里相等于  num1=(short)(num1+33);
        num1 += 33;
        System.out.println("num1=" + num1);
        short num2 = (short) (num1 + 33);
        System.out.println("num2=" + num2);
    }
}
