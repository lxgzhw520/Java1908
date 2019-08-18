package com.lxgzhw.Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo02 {
    public static void main(String[] args) {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("楚枫", 22);
        stringIntegerHashMap.put("萃萃", 22);
        stringIntegerHashMap.put("大黄", 322);
        //遍历集合的所有键
        System.out.println("集合所有的键:");
        Set<String> strings = stringIntegerHashMap.keySet();
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println("-------------------------------");
        //遍历集合所有的值
        System.out.println("集合所有的值:");
        Collection<Integer> values = stringIntegerHashMap.values();
        for (Integer value : values) {
            System.out.println(value);
        }
        System.out.println("-------------------------------");
        //遍历集合的所有键值对
        System.out.println("集合所有的键值对:");
        Set<Map.Entry<String, Integer>> entries = stringIntegerHashMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry);
        }
        System.out.println("-------------------------------");
    }
}
