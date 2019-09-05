package com.lxgzhw.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxgzhw.dao.ProvinceDao;
import com.lxgzhw.dao.impl.ProvinceDaoImpl;
import com.lxgzhw.domain.Province;
import com.lxgzhw.jredis.util.JedisUtils;
import com.lxgzhw.service.ProvinceService;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    //声明dao
    private ProvinceDao dao =
            new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    /**
     * 使用redis缓存
     *
     * @return json格式数据
     */
    @Override
    public String findAllJson() {
        //1.先从redis中查询数据
        Jedis jedis = JedisUtils.getJedis();
        String province = jedis.get("province");
//        System.out.println("1," + province);
//        System.out.println(province.length()==0);
//        System.out.println(province.length());
//        System.out.println(province);

        //2如果没有,则从数据库中查
        if (province == null || province.length() == 2) {
            //2.1 从数据库查询数据
            List<Province> all = dao.findAll();
            System.out.println("2,"+all);
            //2.2 转换为json格式
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                //2.3 将数据存入redis
                province = objectMapper.writeValueAsString(all);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province", province);
            jedis.close();
        }
        System.out.println("..........");
        return province;
    }
}
