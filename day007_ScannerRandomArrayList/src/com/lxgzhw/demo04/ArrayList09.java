package com.lxgzhw.demo04;

import java.util.ArrayList;
import java.util.Random;

public class ArrayList09 {
    public static void main(String[] args) {
        //用一个大集合存入20个随机数,筛选其中的偶数,放到小集合中
        //要求用自定义方法实现筛选
        ArrayList<Integer> integers = new ArrayList<>();
        Random r = new Random();
        //生成随机数集合
        for (int i = 0; i < 20; i++) {
            integers.add(r.nextInt(100));
        }
        //筛选
        integers = getArrayListEven(integers);

        //打印测试
        System.out.println(integers);
    }

    //筛选方法
    static ArrayList getArrayListEven(ArrayList<Integer> arrayList) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if ((arrayList.get(i) % 2) == 0) {
                integers.add(arrayList.get(i));
            }
        }
        return integers;
    }
}
