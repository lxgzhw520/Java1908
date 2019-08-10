package com.lxgzhw;

public class Practice01 {
    public static void main(String[] args) {
        //1
        System.out.println("5%3=" + (5 % 3));
        System.out.println("9%3=" + (9 % 3));
        System.out.println("3%6=" + (3 % 6));

        System.out.println("-------------------------------");
        //2
        int a = 5;
        a++;
        System.out.println("a=" + a);
        int b = 5;
        ++b;
        System.out.println("b=" + b);

        System.out.println("-------------------------------");
        //3
        int c = 5;
        int d = c++;
        System.out.println("c=" + c);
        System.out.println("d=" + d);

        int e = 5;
        int f = ++e;
        System.out.println("e=" + e);
        System.out.println("f=" + f);

        //4
        System.out.println("-------------------------------");
        int g = 5, h = 5;
        System.out.println(g--);
        System.out.println(g);
        System.out.println(--h);
        System.out.println(h);
    }
}
