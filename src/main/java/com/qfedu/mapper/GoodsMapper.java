package com.qfedu.mapper;

import com.qfedu.entry.GoodsType;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper {


    @Results(id = "GoodsMap",
            value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "typeName", column = "typeName"),
            @Result(property = "hot", column = "hot"),
            }
    )
    @Select("select * from goodstype where typeName = #{typeName}")
    GoodsType selectGoodsTypeByGoodsTypeName(String typeName);


    @Select("select * from goodstype")
    @ResultMap("GoodsMap")
    List<GoodsType> selectAllGoodsType();


}
