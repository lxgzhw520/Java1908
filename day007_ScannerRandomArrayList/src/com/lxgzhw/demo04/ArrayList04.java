package com.lxgzhw.demo04;

import java.util.ArrayList;

public class ArrayList04 {
    public static void main(String[] args) {
        ArrayList<String> arrList = new ArrayList<>();
        //添加元素
        arrList.add("楚枫");
        arrList.add("萃萃");
        arrList.add("大黄");

        //遍历集合
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }
    }
}
