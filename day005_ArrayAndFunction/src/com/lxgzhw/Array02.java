package com.lxgzhw;

import java.util.Arrays;

public class Array02 {
    public static void main(String[] args) {
        //数组的复制:方法2

        //源数组
        int[] arr = {11, 22, 33, 44, 55};

        //目标数组
        //多了补0,少了截取
        int[] destArr = Arrays.copyOf(arr, 5);

        //打印测试
        for (int i = 0; i < destArr.length; i++) {
            System.out.print(destArr[i] + "\t");
        }
    }
}
