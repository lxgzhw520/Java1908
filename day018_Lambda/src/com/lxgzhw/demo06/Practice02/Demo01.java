package com.lxgzhw.demo06.Practice02;

public class Demo01 {
    public static void main(String[] args) {
        invokeClac(222, 333, (a, b) -> a + b);
    }

    private static void invokeClac(int a, int b, Calculator c) {
        int sum = c.calc(a, b);
        System.out.println("和是:" + sum);
        System.out.println("-------------------------------");
    }
}
