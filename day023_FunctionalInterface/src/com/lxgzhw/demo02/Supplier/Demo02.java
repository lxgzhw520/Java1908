package com.lxgzhw.demo02.Supplier;

import java.util.Arrays;
import java.util.function.Supplier;

/*
使用Supplier接口方法作为参数类型,
通过Lambda表达式求出int数组的最大值
 */
public class Demo02 {
    //定义接口方法
    static int getMax(Supplier<Integer> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        //1.定义一个int类型的数组
        int[] arr = {11, 2222, 2, 33333, 3, -3333, -111};
        //2.调用getMax接口方法
        int max = getMax(() -> {
            //3.定义数组的最大值
            int maxValue = arr[0];
            //4.遍历数组,求最大值
            //注意:java数组也支持迭代器
            for (int i : arr) {
                if (maxValue < i) {
                    maxValue = i;
                }
            }
            //5.返回最大值
            return maxValue;
        });
        //6.打印最大值
        System.out.println(Arrays.toString(arr));
        System.out.println("-------------------------------");
        System.out.println("该数组的最大值是:" + max);
    }
}
