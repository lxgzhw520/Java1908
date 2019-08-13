package com.lxgzhw.demo04;

import java.util.ArrayList;

public class ArrayList03 {
    public static void main(String[] args) {
        ArrayList<String> arrList = new ArrayList<>();
        //添加元素
        arrList.add("楚枫");
        arrList.add("萃萃");
        arrList.add("大黄");
        System.out.println(arrList);

        //删除元素
        System.out.println("-------------------------------");
        arrList.remove(0);
        System.out.println(arrList);

        //获取元素
        System.out.println("-------------------------------");
        System.out.println(arrList.get(1));

        //查看集合长度
        System.out.println("-------------------------------");
        System.out.println(arrList.size());
    }
}
