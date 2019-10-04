package com.qfedu.service;

import com.qfedu.entry.Brand;
import com.qfedu.entry.User;

import java.util.List;

public interface BrandService {
    List<Brand> selectBrandAll();


    List<Brand> selectBatchByBrandId(User user);
}
