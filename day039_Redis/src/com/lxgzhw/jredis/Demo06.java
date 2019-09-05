package com.lxgzhw.jredis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class Demo06 {
    public static void main(String[] args) {
        //Jedis操作有序集合 zadd zrange zrem
        Jedis localhost = new Jedis("localhost", 6379);
        //1.添加有序集合
        localhost.zadd("mySortedSet", 1, "红眼");
        localhost.zadd("mySortedSet", 2, "魔道");
        localhost.zadd("mySortedSet", 3, "战法");
        localhost.zadd("mySortedSet", 4, "暗帝");
        localhost.zadd("mySortedSet", 5, "机械");
        localhost.zadd("mySortedSet", 6, "混沌");

        //2.获取,打印
        Set<String> mySortedSet = localhost.zrange("mySortedSet", 0, -1);
        System.out.println(mySortedSet);

        //3.删除,获取,打印
        localhost.zrem("mySortedSet", "红眼", "魔道");
        Set<String> mySortedSet1 = localhost.zrange("mySortedSet", 0, -1);
        System.out.println(mySortedSet1);

        localhost.close();
    }
}
