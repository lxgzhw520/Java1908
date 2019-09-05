package com.lxgzhw.jredis;

import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class Demo03 {
    public static void main(String[] args) {
        //Jedis操作hash类型
        //1.获取连接
        Jedis localhost = new Jedis("localhost", 6379);

        //2.操作
        localhost.hset("zhangdapeng1", "name", "张大鹏");
        localhost.hset("zhangdapeng1", "age", "22");
        localhost.hset("zhangdapeng1", "gender", "男");
        //2.1 获取
        String age = localhost.hget("zhangdapeng1", "age");
        System.out.println(age);
        //2.2 获取所有
        Map<String, String> zhangdapeng1 = localhost.hgetAll("zhangdapeng1");
        Set<String> keys = zhangdapeng1.keySet();
        for (String key : keys) {
            System.out.println(key + ":" + zhangdapeng1.get(key));
        }

        //3.关闭
        localhost.close();
    }
}
