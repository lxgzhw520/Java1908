package com.lxgzhw.demo02.Stream;

import java.util.Arrays;
import java.util.stream.Stream;

/*
流的截取方法:limit
    1.如果截取长度符合条件则截取,不符合不会报错
 */
public class Demo06 {
    public static void main(String[] args) {
        String[] arr = {"楚枫", "萃萃", "大黄"};
        //转换为Stream
        Stream<String> stream = Arrays.stream(arr);
        //超出则截取所有,不报错
        Stream<String> limit = stream.limit(4);
        //对截取的进行遍历
        limit.forEach(name -> System.out.println(name));
    }
}
