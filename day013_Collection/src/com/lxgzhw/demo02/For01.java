package com.lxgzhw.demo02;

import java.util.ArrayList;

public class For01 {
    public static void main(String[] args) {
        //增强for循环 底层使用的也是迭代器
        int[] arr = {11, 22, 3, 333};
        for (int i :
                arr) {
            System.out.print(i + "\t");
        }

        //遍历集合
        ArrayList<String> strList = new ArrayList<>();
        strList.add("楚枫");
        strList.add("萃萃");
        strList.add("大黄");

        System.out.println("\n-------------------------------");
        for (String s :
                strList) {
            System.out.println(s);
        }
    }
}
