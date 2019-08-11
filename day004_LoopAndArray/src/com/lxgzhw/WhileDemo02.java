package com.lxgzhw;

public class WhileDemo02 {
    public static void main(String[] args) {
        //求1+2+3....不断往上加,加到多少的时候,和大于333
        int i = 0, sum = 0;
        while (true) {
            sum += i;
            //退出条件
            if (sum > 333) {
                break;
            }
            i++;
        }
        System.out.println("当加到" + i + "的时候,和大于333.值为:" + sum);
    }
}
