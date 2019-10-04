package com.qfedu.mapper;

import com.qfedu.entry.Brand;
import com.qfedu.entry.User;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectBrandAll();

    List<Brand> selectBatchByBrandId(User user);
}
