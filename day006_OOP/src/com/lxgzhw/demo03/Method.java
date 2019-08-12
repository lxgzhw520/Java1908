package com.lxgzhw.demo03;

import java.util.Arrays;

public class Method {
    public static void main(String[] args) {
        int[] arr = {111, 222, 333, 12121, 121, 1212121, 122};

        //调用方法
        int max = getMax(arr);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("最大值为:" + max);
    }

    //取最大值
    public static int getMax(int[] arr) {
        //取其中的最大值
        int max = arr[0];
        //arr.fori 快捷键
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
