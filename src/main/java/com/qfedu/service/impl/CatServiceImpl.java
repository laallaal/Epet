package com.qfedu.service.impl;

import com.qfedu.entry.Cat;

import com.qfedu.mapper.CatMapper;
import com.qfedu.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {
    @Autowired
    CatMapper catMapper;
    @Override
    public List<Cat> selectByUName(String uName) {
        return catMapper.selectByUName(uName);
    }

    @Override
    public Integer selectByUNameAndGid(Cat cat) {
        return catMapper.selectByUNameAndGid(cat);
    }

    @Override
    public Integer addGoodsToCat(Cat cat) {
        return catMapper.addGoodsToCat(cat);
    }

    @Override
    public boolean updateCatByAddNum(Cat cat) {

        System.out.println("1111111");
        int rows = catMapper.updateCatByAddNum(cat);

        System.out.println("22222222");

        return rows > 0 ? true : false;
    }

    @Override
    public boolean updateCatByDeleteNum(Cat cat) {

        int rows = catMapper.updateCatByDeleteNum(cat);

        return rows > 0 ? true : false;
    }

    @Override
    public boolean updateCatByInputNum(Cat cat) {

        int rows = catMapper.updateCatByInputNum(cat);

        return rows > 0 ? true : false;
    }

    @Override
    public boolean deleteGoodsOnCatByGoodsId(Cat cat) {

        int rows = catMapper.deleteGoodsOnCatByGoodsId(cat);

        return rows > 0 ? true : false;
    }


}
