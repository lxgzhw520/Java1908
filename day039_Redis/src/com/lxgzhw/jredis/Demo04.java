package com.lxgzhw.jredis;

import redis.clients.jedis.Jedis;

import java.util.List;

public class Demo04 {
    public static void main(String[] args) {
        //Jedis操作list
        Jedis localhost = new Jedis("localhost", 6379);
        //1.两种存储方式,lpush rpush
        localhost.lpush("mylist", "楚枫", "萃萃");
        localhost.rpush("mylist", "孙悟空", "唐僧");

        //2.取出方式 lrange
        List<String> mylist = localhost.lrange("mylist", 0, -1);

        //3.打印
        System.out.println(mylist);

        //4.两种删除方式lpop rpop
        localhost.lpop("mylist");
        localhost.rpop("mylist");

        localhost.close();
    }
}
