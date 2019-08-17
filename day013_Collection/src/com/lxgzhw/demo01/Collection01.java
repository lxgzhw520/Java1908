package com.lxgzhw.demo01;

import java.util.ArrayList;
import java.util.Collection;

public class Collection01 {
    public static void main(String[] args) {
        //创建集合对象
        //使用多态的方法创建
        Collection<String> strList = new ArrayList<>();

        //添加方法
        //public boolean add(E e)
        ((ArrayList<String>) strList).add("楚枫");
        ((ArrayList<String>) strList).add("萃萃");
        ((ArrayList<String>) strList).add("大黄");
        //打印
        System.out.println(strList);
        System.out.println("-------------------------------");

        //删除方法
        //public boolean remove(E ee)
        strList.remove("楚枫");//根据指定的对象删除


        System.out.println(strList);
        System.out.println("-------------------------------");


        //判断是否包含
        //public boolean contains(E e)
        if (strList.contains("萃萃")) {
            System.out.println("包含该角色.");
        }
        System.out.println("-------------------------------");

        //判断集合是否为空
        if (!strList.isEmpty()) {
            System.out.println("该集合不为空.");
        }
        System.out.println("-------------------------------");

        //查看集合中元素的个数
        System.out.println(strList.size());

        //将集合转换为数组
        Object[] objects = strList.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(i);
        }

    }
}
