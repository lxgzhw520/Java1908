package com.lxgzhw.Collections;

import java.util.ArrayList;
import java.util.Collections;

/*
Collections集合工具类常用方法:
    1.addAll(集合,要添加的元素...) 向集合添加可变参数个元素
    2.shuffle(list集合) 打乱list集合的顺序
 */
public class Demo01 {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        //添加方法
        Collections.addAll(intList, 11, 22, 33, 44, 55, 66);
        //打印
        System.out.println(intList);
        //打乱顺序
        Collections.shuffle(intList);
        //再次打印
        System.out.println(intList);
        //排序
        Collections.sort(intList);
        //再次打印
        System.out.println(intList);
    }
}
