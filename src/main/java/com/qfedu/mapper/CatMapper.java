package com.qfedu.mapper;

import com.qfedu.entry.Cat;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CatMapper {
    List<Cat> selectByUName(String uName);


    Integer selectByUNameAndGid(Cat cat);

    Integer addGoodsToCat(Cat cat);


    @Results(id = "catMap",
            value = {
                    @Result(id = true, property = "id", column = "id"),
                    @Result(property = "uName", column = "uName"),
                    @Result(property = "num", column = "num"),
                    @Result(property = "gid", column = "gid"),
                    @Result(property = "isDelete", column = "isDelete"),
            })

    @Update("update cat set num = num + 1 where gid = #{gid} and uName = #{uName}")
    int updateCatByAddNum(Cat cat) ;



    @Update("update cat set num = num - 1 where gid = #{goodsId} and uName = #{userName}")
    int updateCatByDeleteNum(Cat cat);



    @Update("update cat set num = #{num} where gid = #{gId} and uName = #{uName}")
    int updateCatByInputNum(Cat cat);


    @Delete("delete from cat where gid = #{gId} and uName = #{uName} ")
    int deleteGoodsOnCatByGoodsId(Cat cat);

}
