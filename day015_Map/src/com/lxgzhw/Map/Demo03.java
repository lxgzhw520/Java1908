package com.lxgzhw.Map;

import java.util.HashMap;
import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        //计算字符串中每个字符出现的次数
        //1.录入数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String next = sc.next();
        //2.转换为字符数组
        char[] chars = next.toCharArray();
        //3.创建一个键为字符,值为次数的集合
        //4.1遍历字符数组,进行计算
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            //4.1.1集合有自动去重功能
            //4.1.2先判断集合中有没有该字符的键
            //4.1.3没有就存储,有就让值++
            char key = chars[i];
            boolean b = characterIntegerHashMap.containsKey(key);
            if (b) {
                Integer value = characterIntegerHashMap.get(key);
                characterIntegerHashMap.put(key, ++value);
            } else {
                characterIntegerHashMap.put(key, 1);
            }
        }

        //6.打印集合
        System.out.println(characterIntegerHashMap);
    }
}
