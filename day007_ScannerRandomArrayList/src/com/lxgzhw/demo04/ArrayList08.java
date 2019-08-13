package com.lxgzhw.demo04;

import java.util.ArrayList;

public class ArrayList08 {
    public static void main(String[] args) {
        //{元素1@元素2@元素3}
        ArrayList<String> strings = new ArrayList<>();
        strings.add("楚枫");
        strings.add("萃萃");
        strings.add("大黄");

        //按照格式打印
        arrayListPrint(strings);
    }

    //打印方法
    static void arrayListPrint(ArrayList arr) {
        System.out.print("{");
        for (int i = 0; i < arr.size(); i++) {
            //如果不是最后一个
            if (i != arr.size() - 1) {
                System.out.print(arr.get(i) + "@");
            } else {
                System.out.print(arr.get(i));
            }
        }
        System.out.print("}");
    }
}
