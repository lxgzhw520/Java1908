package com.lxgzhw.test;

import com.lxgzhw.dao.impl.ProvinceDaoImpl;
import com.lxgzhw.domain.Province;
import com.lxgzhw.service.impl.ProvinceServiceImpl;
import org.junit.Test;

import java.util.List;

public class ProvinceServiceTest {
    @Test
    public void test01() {
        String allJson = new ProvinceServiceImpl().findAllJson();
        System.out.println(allJson);
    }

    @Test
    public void test02() {
        ProvinceDaoImpl provinceDao = new ProvinceDaoImpl();
        List<Province> all = provinceDao.findAll();
        System.out.println(all);
    }
}
