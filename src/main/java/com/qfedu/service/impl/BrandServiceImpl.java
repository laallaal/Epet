package com.qfedu.service.impl;

import com.qfedu.entry.Brand;
import com.qfedu.entry.User;
import com.qfedu.mapper.BrandMapper;
import com.qfedu.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper mapper;
    @Override
    public List<Brand> selectBrandAll() {
        return mapper.selectBrandAll();
    }

    @Override
    public List<Brand> selectBatchByBrandId(User user) {
        return mapper.selectBatchByBrandId(user);
    }


}
