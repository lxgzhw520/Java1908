package com.lxgzhw.jredis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisUtils {
    //1.创建连接池对象
    private static JedisPool jedisPool;

    //2.加载连接池
    static {
        //2.1读取配置文件
        InputStream resourceAsStream = JedisPool.class.getClassLoader()
                .getResourceAsStream("jedis.properties");
        //2.2创建Properties对象
        Properties properties = new Properties();
        //2.3加载文件
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.4获取配置数据,设置JedisPollConfig
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        //2.5初始化JedisPool
        jedisPool = new JedisPool(jedisPoolConfig,
                properties.getProperty("host"),
                Integer.parseInt(properties.getProperty("port")));
    }

    //3.写获取连接方法
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
