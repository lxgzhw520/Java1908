package com.lxgzhw;

public class Practice1 {
    public static void main(String[] args) {
        //1
        int a = 6;
        long b = a;
        int c = (int) b;


        //2
        long d = 10000000000L;
        int e = (int) d;
        System.out.println(e);

        float f = 58.8855F;
        int g = (int) f;
        System.out.println(g);

        //3
        byte b1 = 6, b2 = 8;
        byte b3 = (byte) ((int) b1 + (int) b2);
        System.out.println(b3);

        //4
        System.out.println(2 + 2);
        System.out.println(2 + '2');
        System.out.println('2' + '2');

    }
}
