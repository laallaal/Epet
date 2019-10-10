package com.qfedu.mapper;

import com.qfedu.entry.Goods;
import com.qfedu.entry.GoodsType;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodsMapper {


    @Results(id = "GoodsMap",
            value = {
                    @Result(id = true, property = "id", column = "id"),
                    @Result(property = "typeName", column = "typeName"),
                    @Result(property = "goodsTypeImg", column = "typeImg"),
                    @Result(property = "hot", column = "hot"),
                    @Result(property = "directoryId", column = "directoryId"),

            }
    )
    @Select("select * from goodstype where id = #{typeId}")
    GoodsType selectGoodsTypeByGoodsTypeId(int typeId);


    @Select("select * from goodstype")
    @ResultMap("GoodsMap")
    List<GoodsType> selectAllGoodsType();






    List<Goods> queryGoodsByTypeId(Integer typeId);

    List<Goods> selectGoodsBySelective(String goodsName);

    Goods selectGoodsById(Integer id);



    List<Goods> selectAllGoods();




    @Select("select * from goodstype where directoryId = #{directoryId}  ")
    @ResultMap("GoodsMap")
    List<GoodsType> selectAllGoodsTypeByDirectoryId(int directoryId);
}
