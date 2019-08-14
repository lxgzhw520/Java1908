package com.lxgzhw.demo04;

public class Math01 {
    public static void main(String[] args) {
        //获取绝对值
        double num = -33.333;
        System.out.println(Math.abs(num));
        //向上取整
        System.out.println(Math.ceil(num));
        //向下取整
        System.out.println(Math.floor(num));
        //四舍五入
        System.out.println(Math.round(num));
    }
}
