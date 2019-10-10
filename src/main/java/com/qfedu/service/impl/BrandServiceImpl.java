package com.qfedu.service.impl;

import com.qfedu.entry.Brand;
import com.qfedu.entry.GoodsType;
import com.qfedu.entry.User;
import com.qfedu.mapper.BrandMapper;
import com.qfedu.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Stream
 * @version 1.0
 * @date 2019/10/04 10:16
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;

    @Override
    public List<Brand> selectBrand(String brandName) {
        return brandMapper.selectBrand(brandName);
    }

    @Override
    public List<Brand> selectBrandById(Integer brandId) {
        return brandMapper.selectBrandById(brandId);
    }



    @Override
    public List<Brand> selectBrandAll() {
        return brandMapper.selectBrandAll();
    }

    @Override
    public List<Brand> selectBatchByBrandId(User user) {
        return brandMapper.selectBatchByBrandId(user);
    }
    @Override
    public List<GoodsType> selectAllBrandIdByDirectoryId(int directoryId) {

        return brandMapper.selectAllBrandIdByDirectoryId(directoryId);
    }

}
