package com.lxgzhw.service;

import com.lxgzhw.domain.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();//查询所有省份

    String findAllJson();//查询所有省份的json格式
}
