package com.qfedu.utils;

import com.qfedu.entry.GoodsType;

import java.util.List;

public class HotGoodsType {


    public static List<GoodsType> selectHotGoodsType(List<GoodsType> goodsTypeList) {

        int temp = 0;
        for (int i = 0; i < goodsTypeList.size(); i++) {

            for (int j = i + 1; j < goodsTypeList.size(); j++) {

                if (goodsTypeList.get(i).getHot() < goodsTypeList.get(j).getHot()) {

                    temp = goodsTypeList.get(j).getHot();
                    goodsTypeList.get(j).setHot(goodsTypeList.get(i).getHot());
                    goodsTypeList.get(i).setHot(temp) ;


                }

            }


        }


        if (goodsTypeList.size() <= 6) {
            return goodsTypeList;
        }

        List<GoodsType> list = goodsTypeList.subList(0, 6);

        return list;

    }

}
