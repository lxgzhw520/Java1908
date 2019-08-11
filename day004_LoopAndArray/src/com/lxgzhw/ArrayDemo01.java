package com.lxgzhw;

public class ArrayDemo01 {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = new int[10];

        //遍历数组并赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        //打印数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
