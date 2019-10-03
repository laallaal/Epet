package com.qfedu.entry;

import lombok.Data;

@Data
public class Goods {
    private Integer id;
    private String goodsName;
    private Double price;
    private Integer goodsTypeId;
    private String goodsImg;
    private String goodsDesc;
    private Integer kindId;
    private Integer brandId;

    public Goods() {
    }

    public Goods(Integer id, String goodsName, Double price, Integer goodsTypeId, String goodsImg, String goodsDesc, Integer kindId, Integer brandId) {
        this.id = id;
        this.goodsName = goodsName;
        this.price = price;
        this.goodsTypeId = goodsTypeId;
        this.goodsImg = goodsImg;
        this.goodsDesc = goodsDesc;
        this.kindId = kindId;
        this.brandId = brandId;
    }

}