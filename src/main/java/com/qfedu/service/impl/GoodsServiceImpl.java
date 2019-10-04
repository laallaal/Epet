package com.qfedu.service.impl;


import com.qfedu.entry.GoodsType;
import com.qfedu.mapper.GoodsMapper;
import com.qfedu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public GoodsType selectGoodsTypeByGoodsTypeName(String typeName) {

        GoodsType goodsType = goodsMapper.selectGoodsTypeByGoodsTypeName(typeName);

        return goodsType;
    }

    @Override
    public List<GoodsType> selectAllGoodsType() {
        List<GoodsType> goodsTypes = goodsMapper.selectAllGoodsType();
        return goodsTypes;
    }
}
