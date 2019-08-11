package com.lxgzhw;

import java.util.Arrays;

public class Array03 {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33};
        //扩容
        arr = Arrays.copyOf(arr, arr.length + 1);
        //遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
