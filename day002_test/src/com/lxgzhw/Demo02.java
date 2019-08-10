package com.lxgzhw;

public class Demo02 {
    public static void main(String[] args) {
        //基本数据类型转换

        //1.自动转换 小->大
        byte num1 = 3;
        int num2 = num1;

        //2.强制类型转换 大->小
        double num3 = 33.33;
        int num4 = (int) num3;

        System.out.println("num2=" + num2);
        System.out.println("num4=" + num4);
    }
}
