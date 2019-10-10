package com.qfedu.mapper;

/**
 * @author Stream
 * @version 1.0
 * @date 2019/10/04 11:53
 */
public interface GoodsTypeMapper {
    int addHot(String typeName);

    int addHotById(Integer typeId);
}
