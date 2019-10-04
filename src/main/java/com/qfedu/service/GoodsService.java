package com.qfedu.service;

import com.qfedu.entry.GoodsType;

import java.util.List;

public interface GoodsService {

    GoodsType selectGoodsTypeByGoodsTypeName(String typeName);

    List<GoodsType> selectAllGoodsType();


}
