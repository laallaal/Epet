package com.qfedu.service;

import com.qfedu.entry.Goods;
import com.qfedu.entry.GoodsType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GoodsService {



    List<GoodsType> selectAllGoodsType();




    @Transactional(readOnly = false, rollbackFor = Exception.class)
    List<Goods> queryGoodsByTypeId(Integer typeId);


    List<Goods> selectGoodsBySelective(String goodsName);


    GoodsType selectGoodsTypeByGoodsTypeId(int typeId);

    Goods selectGoodsById(Integer id);

    List<Goods> selectAllGoods();

    List<GoodsType> selectAllGoodsTypeByDirectoryId(int directoryId);
}
