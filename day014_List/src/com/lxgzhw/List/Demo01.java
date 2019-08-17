package com.lxgzhw.List;

import java.util.ArrayList;
import java.util.List;

/*
List集合的特点:
    1.有序
    2.有索引
    3.可以重复
List集合常用方法:
    1.add(索引,元素) 增加元素到集合
    2.get(索引) 根据索引获取元素
    3.remove(索引) 移除指定索引的元素
    4.set(索引,元素) 替换指定位置的元素
 */
public class Demo01 {
    public static void main(String[] args) {
        //创建List集合
        //多态
        List<String> strings = new ArrayList<>();
        strings.add("楚枫");
        strings.add("萃萃");
        strings.add("大黄");

        //获取
        System.out.println(strings.get(1));
        //移除
        strings.remove(1);
        //替换
        strings.set(1, "哈哈哈");
        System.out.println(strings);
        System.out.println("-------------------------------");

        //遍历
        for (String string : strings) {
            System.out.println(string);
        }

    }
}
