package com.lxgzhw;

import java.util.Arrays;

public class Array05 {
    public static void main(String[] args) {

        //定义一个数组
        int[] arr = {11, 1, 2, 3, 333, 2, 22, 3222};
        //升序
        Arrays.sort(arr);

        //打印测试
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

    }
}
