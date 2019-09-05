package com.lxgzhw.jredis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class Demo05 {
    public static void main(String[] args) {
        //Jedis操作无序集合 sadd srem  smembers
        Jedis localhost = new Jedis("localhost", 6379);
        //1.添加
        localhost.sadd("myset", "孙悟空", "唐僧", "猪八戒", "沙僧");

        //2.获取,打印
        Set<String> myset = localhost.smembers("myset");
        System.out.println(myset);

        //3.删除,打印
        localhost.srem("myset", "孙悟空", "唐僧");
        Set<String> myset1 = localhost.smembers("myset");
        System.out.println(myset1);
        
        localhost.close();
    }
}
