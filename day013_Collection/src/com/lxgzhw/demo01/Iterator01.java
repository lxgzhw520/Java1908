package com.lxgzhw.demo01;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterator01 {
    public static void main(String[] args) {
        //迭代器的使用
        ArrayList<String> roleList = new ArrayList<>();
        roleList.add("楚枫");
        roleList.add("萃萃");
        roleList.add("大黄");

        //迭代
        //boolean hasNext()判断有没有下一个
        //E next()取出下一个
        //Collection接口中有一个方法,iterator,返回的就是迭代器对象
        Iterator<String> iterator = roleList.iterator();
        //遍历
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");
        }
    }
}
