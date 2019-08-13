package com.lxgzhw.demo03;

import java.util.Random;

public class Random02 {
    public static void main(String[] args) {
        Random r = new Random();

        //生成随机数数组
        for (int i = 0; i < 100; i++) {
            int num = r.nextInt(10);
            System.out.print(num + "\t");
        }
    }
}
