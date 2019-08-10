package com.lxgzhw;

public class Operator04 {
    public static void main(String[] args) {
        int a = 3, b = 3;

        //总结:被使用的时候,++在后,得到的是未自增之前的值
        //++在前,得到的是自增后的值
        //一句话:++在前先自增后执行,++在后,先执行后自增
        System.out.println(a++);//3
        System.out.println(a);//4
        System.out.println(++b);//4
        System.out.println(b);//4
    }
}
