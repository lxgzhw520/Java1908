package com.lxgzhw.demo01.Stream;

import java.util.ArrayList;

/*
根据福建南平刘姓辈分表:
国、泰、玉、明，初、孔、白、梦，正、宗、德、仪，永、春，启、元，士、英、子、宁，林、考、岳、恩，生、秉、礼、义，仕、名、朝、庭，克、米、尔、祖，万、世、永、盛
传统方法过滤集合
    集合中有:
        楚枫,萃萃,大黄,狌狌,道凌,道天,刘国兵,刘国柱,刘国梁
        1.筛选出所有姓刘的人
        2.筛选出名字是三个字的人
        3.筛筛出国字辈的人
        4.放在一个新集合中
        5.打印集合
 */
public class Demo01 {
    public static void main(String[] args) {
        //传统方法
        //1.创建集合
        ArrayList<String> names = new ArrayList<>();
        //2.添加集合元素
        names.add("楚枫");
        names.add("萃萃");
        names.add("大黄");
        names.add("狌狌");
        names.add("道凌");
        names.add("道天");
        names.add("刘国兵");
        names.add("刘国柱");
        names.add("刘国梁");
        //3.创建新集合
        ArrayList<String> newNames = new ArrayList<>();
        //4.遍历集合,筛选出符合条件的放到新集合
        for (String name : names) {
            if (name.startsWith("刘") &&
                    name.length() == 3 &&
                    name.contains("国")) {
                newNames.add(name);
            }
        }
        //5.遍历新集合打印
        for (String newName : newNames) {
            System.out.println(newName);
        }
    }
}
