package com.lxgzhw.demo03.Generic;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo05Generic {
    public static void main(String[] args) {
        //创建两种类型的集合,分别调用遍历方法
        ArrayList<String> strings = new ArrayList<>();
        strings.add("楚枫");
        strings.add("萃萃");
        strings.add("大黄");
        printArray(strings);

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(233);
        integers.add(233332);
        printArray(integers);
    }

    /*
    泛型通配符 ?
    1.只能作为方法的参数使用
    2.用来表示可以接收任意的数据类型
     */
    //定义一个方法,可以遍历打印任意类型集合
    static void printArray(ArrayList<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");
        }
        System.out.println("\n-------------------------------");
    }
}
