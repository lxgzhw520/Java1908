package com.lxgzhw.demo02.Stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

/*
获取Stream流的常用方法
 */
public class Demo01 {
    public static void main(String[] args) {
        //1.将ArrayList转换为流
        ArrayList<String> names = new ArrayList<>();
        names.add("楚枫");
        Stream<String> arrayListStream = names.stream();

        //2.将HashSet转换为流
        HashSet<String> names01 = new HashSet<>();
        names01.add("楚枫");
        Stream<String> hashSetStream = names01.stream();

        //3.将HashMap的键转换为流
        HashMap<String, Integer> students = new HashMap<>();
        students.put("楚枫",22);
        Stream<String> hashMapKeyStream = students.keySet().stream();

        //4.将HashMap的值转换为流
        Stream<Integer> hashMapValueStream = students.values().stream();

        //5.将HashMap的键值对转换为流
        Stream<Map.Entry<String, Integer>> hashMapKeyValueStream = students.entrySet().stream();

        //6.直接创建流
        Stream<String> roles = Stream.of("楚枫", "萃萃", "大黄");
    }
}
