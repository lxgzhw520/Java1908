package com.lxgzhw.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Demo04 {
    public static void main(String[] args) {
        //LinkedHashSet
        //有序不重复的集合
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);
        hs.add(5);
        System.out.println(hs);
        System.out.println("-------------------------------");
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(1);
        lhs.add(2);
        lhs.add(3);
        lhs.add(4);
        lhs.add(5);
        System.out.println(lhs);
        System.out.println("-------------------------------");
    }
}
