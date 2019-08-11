package com.lxgzhw;

public class ArrayDemo02 {
    public static void main(String[] args) {
        //1
        int[] arr1 = new int[10];
        //2
        int[] arr2 = {2, 5, 8, 9};
        int[] arr3;
        arr3 = new int[]{2, 5, 8, 9};

        //3
        int[] arr = new int[3];
        arr[0] = 100;
        arr[1] = 200;
        arr[2] = 300;
        System.out.println("数组长度为:" + arr.length);
        System.out.println("数组的最后一个元素的值为:" + arr[arr.length - 1]);
    }
}
