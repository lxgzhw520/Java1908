package com.lxgzhw;

public class Array01 {
    public static void main(String[] args) {
        //数组的复制
        int[] arr = {11, 22, 33, 44};
        int[] targetArr = new int[4];

        //复制方法
        //参数:源数组,开始索引,目标数组,开始索引,要复制的元素个数
        System.arraycopy(arr, 0, targetArr, 0, 4);

        //遍历
        for (int i = 0; i < targetArr.length; i++) {
            System.out.print(targetArr[i] + "\t");
        }
    }
}
