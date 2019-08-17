package com.lxgzhw.Set;

import java.util.HashSet;

/*
Set集合的特点:
    1.不允许重复
    2.没有索引

HashSet的特点:
    1.不重复
    2.没有索引
    3.无序
    4.底层是哈希表结构,查询非常快
 */
public class Demo01 {
    public static void main(String[] args) {
        //定义集合,自动去重
        HashSet<Integer> integers = new HashSet<>();
        integers.add(11);
        integers.add(11);
        integers.add(133);
        integers.add(133333);
        //遍历集合
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
