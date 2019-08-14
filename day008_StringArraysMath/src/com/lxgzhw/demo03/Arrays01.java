package com.lxgzhw.demo03;

import java.util.Arrays;

public class Arrays01 {
    public static void main(String[] args) {
        //将数组变化为字符串
        int[] arr = {11, 232, 33, 32, 32, 32, 32};
        String s = Arrays.toString(arr);
        System.out.println(s);
        System.out.println("-------------------------------");

        //对数组进行升序排序
        Arrays.sort(arr);
        String s1 = Arrays.toString(arr);
        System.out.println(s1);
        System.out.println("-------------------------------");

    }
}
