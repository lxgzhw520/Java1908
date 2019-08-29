package com.lxgzhw.demo01.Stream;

import java.util.stream.Stream;

public class Demo02 {
    public static void main(String[] args) {
        //用Stream流来完成前面的练习
        /*
        Stream流类似于Python中的生成器:
            1.只能取一次
            2.比传统集合效率更高
            3.是管道流
         */
        //1.创建集合
        Stream<String> names = Stream.of("楚枫",
                "萃萃",
                "大黄",
                "狌狌",
                "道凌",
                "道天",
                "刘国兵",
                "刘国柱",
                "刘国梁"
        );
        //2.过滤集合
        names
                .filter(name -> name.startsWith("刘"))
                .filter(name -> name.length() == 3)
                .filter(name -> name.contains("国"))
                .forEach(name -> System.out.println(name));
    }
}
