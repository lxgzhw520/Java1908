package com.lxgzhw.demo02.Stream;

import java.util.stream.Stream;

/*
流的统计方法:count
    1.这是一个终结方法,调用后不可再使用其他方法
    2.一般放在最后使用
    3.返回值是long类型的整数
 */
public class Demo05 {
    public static void main(String[] args) {
        //案例:统计有多少个人
        Stream<String> names = Stream.of("楚枫", "萃萃", "大黄");
        long count = names.count();
        System.out.println("总共有:" + count + "个人");
    }
}
