package com.qfedu.service;

import com.qfedu.entry.GoodsType;

import java.util.List;

/**
 * @author Stream
 * @version 1.0
 * @date 2019/10/04 09:48
 */
public interface GoodsTypeService {
    List<GoodsType> getGoodsTypeByParent(String parents);
}
