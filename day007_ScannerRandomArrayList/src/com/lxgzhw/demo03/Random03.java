package com.lxgzhw.demo03;

import java.util.Random;

public class Random03 {
    public static void main(String[] args) {
        int n = 10;
        Random r = new Random();

        //多来几次
        for (int i = 0; i < 100; i++) {
            //生成随机数,整体+1
            int randomNum = r.nextInt(n) + 1;
            System.out.print(randomNum + "\t");
        }
    }
}
