package com.lxgzhw.demo02.Stream;

import java.util.stream.Stream;

/*
流的映射方法:map
    1.参数是Function接口方法
    2.可以用Lambda优化
    3.将一种类型转换为另一种类型
 */
public class Demo04 {
    public static void main(String[] args) {
        //案例:将字符串转换为浮点数
        Stream<String> nums = Stream.of("1", "2.22", "3");
        nums.map(num -> Float.parseFloat(num))
                .forEach(num -> System.out.println(num));
    }
}
