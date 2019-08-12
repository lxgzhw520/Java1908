package com.lxgzhw.demo01;

import java.util.Arrays;

/**
 * 面向过程:当需要实现一个功能的时候,
 * 每一个具体的步骤都要亲力亲为,详细处理每一个细节
 * <p>
 * 面向对象:当需要实现一个功能的时候,
 * 不关心具体的步骤,而是找一个已经具有该功能的
 * 人,来帮我做事儿
 */
public class Demo01PrintArray {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44};

        //要求打印格式为:[11,22,33,44]
        //使用面向过程
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            //判断是否为最后一个元素
            if (i == arr.length - 1) {
                System.out.println(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ", ");
            }
        }

        //使用面向对象
        //找一个JDK给我们提供好的Arrays类
        //直接就能把数组变成想要的字符串
        System.out.println("-------------------------------");
        System.out.println(Arrays.toString(arr));
    }
}
