package com.lxgzhw.demo02.Stream;

import java.util.stream.Stream;

/*
流过滤方法:filter
    1.参数是Predicate的接口方法
    2.可以用Lambda表达式优化
 */
public class Demo03 {
    public static void main(String[] args) {
        //案例:过滤出姓刘的人
        Stream<String> liu = Stream.of("刘国兵",
                "刘国栋", "刘国梁", "张德军", "张德福", "张德勇");
        liu.filter(name -> name.startsWith("刘"))
                .forEach(name -> System.out.println(name));
    }
}
