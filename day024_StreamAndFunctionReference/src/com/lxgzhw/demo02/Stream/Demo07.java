package com.lxgzhw.demo02.Stream;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
流的跳过方法:skip
    1.用于跳过前面的指定参数个元素
    2.返回值是跳过后剩余元素的新流
 */
public class Demo07 {
    public static void main(String[] args) {
        int[] arr = {11, 222, 333, 121, 21, 2, 1212, 121};
        //转换流
        IntStream stream = Arrays.stream(arr);
        //跳过前面的三个元素
        IntStream skip = stream.skip(3);
        //遍历:引用方法优化Lambda
        skip.forEach(System.out::println);
    }
}
