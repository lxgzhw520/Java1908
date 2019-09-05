package com.lxgzhw.jredis;

import redis.clients.jedis.Jedis;

public class Demo02 {
    public static void main(String[] args) {
        //1.获取连接
        Jedis localhost = new Jedis("localhost", 6379);
        //2.使用 setex
        //2.1 设置字符串和获取字符串
        localhost.set("code", "aabb");
        String code = localhost.get("code");
        System.out.println(code);

        //2.2 指定过期时间的的字符串
        localhost.setex("code", 20, "okok");
        String code1 = localhost.get("code");
        System.out.println(code1);
        //3.关闭
        localhost.close();
    }
}
