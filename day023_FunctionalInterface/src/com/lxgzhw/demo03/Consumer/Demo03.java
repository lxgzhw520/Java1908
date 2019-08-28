package com.lxgzhw.demo03.Consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

/*
练习:
    要求用函数式接口拼接两个步骤
    1.定义一个整型数组
    2.将数组中的所有数都乘上2输出
    3.将数组中的所有数都除上2输出
 */
public class Demo03 {
    //接口方法
    static void operatorNum(int[] arr,
                            Consumer<Integer> con1,
                            Consumer<Integer> con2) {
        //遍历数组,消费每一个数
        for (int i : arr) {
            con1.andThen(con2).accept(i);
        }
    }

    //主方法
    public static void main(String[] args) {
        //1.定义一个数组
        int[] arr = {111, 2, 222, -333, 33, 555};
        //1.1 定义两个集合,用来存储计算后的结果
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        //2.调用接口方法
        operatorNum(arr, (i) -> {
            i *= 2;
            arr1.add(i);
        }, (i) -> {
            i = i / 2;
            arr2.add(i);
        });
        //3.打印
        System.out.println("原数组:");
        System.out.println(Arrays.toString(arr));
        System.out.println("-------------------------------");
        System.out.println("数组中每个数乘2的结果为:");
        System.out.println(arr1);
        System.out.println("-------------------------------");
        System.out.println("数组中每个数除以2的结果为:");
        System.out.println(arr2);
    }
}
