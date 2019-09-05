package com.lxgzhw.test;

import com.lxgzhw.dao.impl.ProvinceDaoImpl;
import com.lxgzhw.domain.Province;
import org.junit.Test;

import java.util.List;

public class ProvinceTest {
    @Test
    public void test01() {
        System.out.println("hhh");
    }

    @Test
    public void testProvinceDaoImpl() throws Exception {
        List<Province> all = new ProvinceDaoImpl().findAll();
        System.out.println(all);
    }
}
