package com.qfedu.service.impl;


import com.qfedu.entry.Goods;
import com.qfedu.entry.GoodsType;
import com.qfedu.mapper.GoodsMapper;
import com.qfedu.mapper.GoodsTypeMapper;
import com.qfedu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsTypeMapper goodsTypeMapper;



    @Override
    public List<GoodsType> selectAllGoodsType() {
        List<GoodsType> goodsTypes = goodsMapper.selectAllGoodsType();
        return goodsTypes;
    }




    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public List<Goods> queryGoodsByTypeId(Integer typeId) {
        int result = goodsTypeMapper.addHotById(typeId);
        return goodsMapper.queryGoodsByTypeId(typeId);
    }

    @Override
    public List<Goods> selectGoodsBySelective(String goodsName) {

        System.out.println("22222222222222222222222");
        return goodsMapper.selectGoodsBySelective(goodsName);
    }

    @Override
    public GoodsType selectGoodsTypeByGoodsTypeId(int typeId) {

        System.out.println("jiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");


        GoodsType goodsType = goodsMapper.selectGoodsTypeByGoodsTypeId(typeId);

        return goodsType;
    }

    @Override
    public Goods selectGoodsById(Integer id) {
        return goodsMapper.selectGoodsById(id);

    }

    @Override
    public List<Goods> selectAllGoods() {


        return goodsMapper.selectAllGoods();
    }

    @Override
    public List<GoodsType> selectAllGoodsTypeByDirectoryId(int directoryId) {


        return  goodsMapper.selectAllGoodsTypeByDirectoryId(directoryId);
    }

}
