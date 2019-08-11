package com.lxgzhw;

import java.util.Arrays;

public class Array04 {
    public static void main(String[] args) {
        //求数组元素的最大值,并插入到数组最后一个元素的后面

        //定义一个数组,然后用随机数填充
        int[] arr = new int[5];
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }

        //对数组进行扩容
        arr = Arrays.copyOf(arr, len + 1);

        //求数组最大值,然后替换到最后一个元素
        int max = arr[0];
        for (int i = 0; i < len + 1; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        arr[len] = max;

        //遍历输出
        for (int i = 0; i < len + 1; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
