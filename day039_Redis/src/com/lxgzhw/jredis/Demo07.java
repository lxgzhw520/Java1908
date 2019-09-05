package com.lxgzhw.jredis;

import com.lxgzhw.jredis.util.JedisUtils;
import redis.clients.jedis.Jedis;

public class Demo07 {
    public static void main(String[] args) {
        //1.获取jedis连接
        Jedis jedis = JedisUtils.getJedis();

        //2.设置String类型数据,获取,打印
        jedis.set("testPool", "连接池测试");
        String testPool = jedis.get("testPool");
        System.out.println(testPool);
    }
}
