package com.lxgzhw.demo04;

import java.util.ArrayList;

public class ArrayList02 {
    public static void main(String[] args) {
        //字符串类型的数据
        //JDK 1.7 以上,右侧尖括号可以不写内容
        ArrayList<String> strList = new ArrayList<>();

        //查看内容
        //可以发现,是一个空数组
        System.out.println(strList);

        System.out.println("-------------------------------");
        //向集合中添加数据
        strList.add("楚枫");
        strList.add("萃萃");
        strList.add("大黄");
        System.out.println(strList);



    }
}
