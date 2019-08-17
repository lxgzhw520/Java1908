package com.lxgzhw.demo03.Generic;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo01Generic {
    public static void main(String[] args) {
        //调用方法
        show();
        System.out.println("-------------------------------");
        show2();
        System.out.println("-------------------------------");
    }

    /*
    创建集合对象,使用泛型:
    优势:
        1.避免了转换的麻烦,存什么类型取什么类型
        2.把运行期异常提升到编译期
    劣势:
        1.泛型是什么类型,只能存储什么类型
     */
    static void show() {
        ArrayList<String> strList = new ArrayList<>();
        //添加元素
        strList.add("楚枫");
        strList.add("萃萃");
        strList.add("大黄");

        //使用迭代器遍历集合
        Iterator<String> strIterator = strList.iterator();
        while (strIterator.hasNext()) {
            System.out.println(strIterator.next());
        }
    }

    /*
    创建集合对象,不使用泛型:
    优势:
        1.默认类型就是Object类型,可以存储任意类型的数据
    劣势:
        1.不安全,会引发异常
     */
    static void show2() {
        ArrayList arrayList = new ArrayList();
        //可以添加任意类型的数据
        arrayList.add("字符串");
        arrayList.add(111);
        arrayList.add(33.333);

        //遍历集合
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
