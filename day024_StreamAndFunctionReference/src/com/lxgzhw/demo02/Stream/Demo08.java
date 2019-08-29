package com.lxgzhw.demo02.Stream;

import java.util.Arrays;
import java.util.stream.Stream;

/*
流的拼接方法:concat
    1.用于将两个流拼接在一起
    2.非接口方法
    3.参数是两个参数
    4.静态方法,直接通过Stream类调用
    5.参数类型必须一致才能拼接
 */
public class Demo08 {
    public static void main(String[] args) {
        String[] arr1 = {"楚枫", "萃萃", "大黄"};
        String[] arr2 = {"楚枫", "萃萃", "大黄"};
        //转换流
        Stream<String> stream = Arrays.stream(arr1);
        Stream<String> stream1 = Arrays.stream(arr2);
        //拼接
        Stream<String> concat = Stream.concat(stream1, stream);
        //遍历
        concat.forEach(System.out::println);
    }
}
