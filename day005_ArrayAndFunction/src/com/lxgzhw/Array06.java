package com.lxgzhw;

public class Array06 {
    public static void main(String[] args) {
        //冒泡排序
        int[] arr = {1, 1111, 1, 111, 11, 2, 2222, 22, 222};

        //冒泡排序就是从头依次比较,将较大的放在最上面
        //需要两层循环
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    //交换
                    int temp = 0;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        //遍历输出
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
