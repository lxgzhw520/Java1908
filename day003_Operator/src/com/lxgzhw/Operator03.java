package com.lxgzhw;

public class Operator03 {
    public static void main(String[] args) {
        //参与其他运算的时候
        int a = 33, b = 55;

        //这里先执行 c的赋值,然后再执行的a的自增
        //所以,c是原本的a的值,而a是自增后的值
        int c = a++;

        //这里先执行b的自增,然后执行d的赋值
        //所以d和b都是自增后的值
        int d = ++b;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("c=" + c);
        System.out.println("d=" + d);
    }
}
