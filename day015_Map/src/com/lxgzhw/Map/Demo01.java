package com.lxgzhw.Map;

import java.util.HashMap;

/*
Map集合:
    1.存储的是键值对
    2.键不允许重复
    3.HashMap是无序集合
    4.LinkedHashMap是有序集合
 */
public class Demo01 {
    public static void main(String[] args) {
        //集合的添加方法
        //put(键,值) 没有就添加,有就修改,和python字典一样
        mapAdd();

        //集合的删除方法
        //remove(键) 根据键删除值
        //存在返回删除的值,不存在返回null,不会报错
        mapRemove();

        //集合的查找方法
        //get(键) 根据键获取值
        //存在返回值,不存在返回null,不会报错
        mapGet();

        //集合的判断方法
        //containsKey(键) 根据键判断该键值对是否已存在
        //返回对应的布尔值
        mapContains();
    }

    private static void mapContains() {
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        integerStringHashMap.put(1, "楚枫");
        integerStringHashMap.put(2, "楚枫");
        integerStringHashMap.put(3, "楚枫");
        System.out.println("判断:");
        System.out.println(integerStringHashMap.containsKey(1));
        System.out.println(integerStringHashMap.containsKey(2));
        System.out.println(integerStringHashMap.containsKey(3));
        System.out.println(integerStringHashMap.containsKey(4));
    }

    private static void mapGet() {
        HashMap<String, Boolean> stringBooleanHashMap = new HashMap<>();
        stringBooleanHashMap.put("楚枫", true);
        stringBooleanHashMap.put("萃萃", true);
        stringBooleanHashMap.put("大黄", false);
        System.out.println(stringBooleanHashMap);
        System.out.println("-------------------------------");
        stringBooleanHashMap.remove("大黄");
        System.out.println(stringBooleanHashMap);
        System.out.println("-------------------------------");
        System.out.println("获取楚枫的值:");
        System.out.println(stringBooleanHashMap.get("楚枫"));
        System.out.println("-------------------------------");
        System.out.println("获取已删除的大黄的值:");
        System.out.println(stringBooleanHashMap.get("大黄"));
        System.out.println("-------------------------------");
    }

    private static void mapRemove() {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("楚枫", 22);
        stringIntegerHashMap.put("萃萃", 22);
        stringIntegerHashMap.put("大黄", 322);
        System.out.println(stringIntegerHashMap);
        System.out.println("-------------------------------");
        System.out.println("删除大黄:");
        stringIntegerHashMap.remove("大黄");
        System.out.println("删除中....");
        System.out.println("删除成功.");
        System.out.println(stringIntegerHashMap);
        System.out.println("-------------------------------");
    }

    private static void mapAdd() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("楚枫", "萃萃");
        System.out.println(stringStringHashMap);
        System.out.println("-------------------------------");
    }
}
