package com.lxgzhw.dao;

import com.lxgzhw.domain.Province;

import java.util.List;

public interface ProvinceDao {
    //查询所有的省份
    List<Province> findAll();
}
