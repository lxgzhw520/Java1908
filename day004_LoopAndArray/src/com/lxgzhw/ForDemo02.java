package com.lxgzhw;

public class ForDemo02 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            sum += i;
        }
        System.out.println("1加到100的和为:" + sum);
    }
}
