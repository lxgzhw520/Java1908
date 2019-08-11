package com.lxgzhw;

public class WhileDemo01 {
    public static void main(String[] args) {
        int sum = 0, i = 0;
        while (i < 101) {
            sum += i;
            i++;
        }
        System.out.println("1加到100的和为:" + sum);
    }
}
