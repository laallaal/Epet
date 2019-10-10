package com.qfedu.mapper;

import com.qfedu.entry.Brand;
import com.qfedu.entry.GoodsType;
import com.qfedu.entry.User;

import java.util.List;

/**
 * @author Stream
 * @version 1.0
 * @date 2019/10/04 10:17
 */
public interface BrandMapper {
    List<Brand> selectBrand(String brandName);

    List<Brand> selectBrandById(Integer brandId);

    List<Brand> selectBrandAll();

    List<Brand> selectBatchByBrandId(User user);
    List<GoodsType> selectAllBrandIdByDirectoryId(int directoryId);

}
