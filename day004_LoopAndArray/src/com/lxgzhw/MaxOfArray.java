package com.lxgzhw;

//求数组元素的最大值
public class MaxOfArray {
    public static void main(String[] args) {
        //定义数组
        int[] arr = new int[10];

        //随机赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        //打印输出
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        //从数组中找到最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println();
        System.out.println("数组中的最大值为:" + max);
    }
}
