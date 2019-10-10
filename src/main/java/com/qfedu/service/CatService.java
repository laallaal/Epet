package com.qfedu.service;

import com.qfedu.entry.Cat;

import java.util.List;

public interface CatService {
    List<Cat> selectByUName(String uName);


    Integer selectByUNameAndGid(Cat cat);

    Integer addGoodsToCat(Cat cat);

    boolean updateCatByAddNum(Cat cat);

    boolean updateCatByDeleteNum(Cat cat);

    boolean updateCatByInputNum(Cat cat);

    boolean deleteGoodsOnCatByGoodsId(Cat cat);

}
