package com.lxgzhw.jredis;

import redis.clients.jedis.Jedis;

public class Demo01 {
    public static void main(String[] args) {
        //1.获取连接
        Jedis localhost = new Jedis("localhost", 6379);
        //2.操作
        localhost.set("zhangdapeng", "22");
        //3.关闭连接
        localhost.close();
    }
}
