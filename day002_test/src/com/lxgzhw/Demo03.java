package com.lxgzhw;

public class Demo03 {
    public static void main(String[] args) {

        //正常情况下能够运行
        System.out.println(2 + 2);

        //char,byte,short类型需要先转换为int类型再运行
        //字符从加法运算,实际上加的是Unicode编码
        System.out.println('2' + '2');

        char num1 = '3';
        int num2 = (int) num1;
        System.out.println(num2);
        //将字符转换为int类型,得到的也是Unicode编码值


        System.out.println((int) '2' + (int) '2');
    }
}
