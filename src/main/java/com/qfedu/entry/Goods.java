package com.qfedu.entry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Goods实体", description = "用于接收和传递商品信息")
public class Goods {
    private Integer id;
    @ApiModelProperty(value = "商品名称",name = "goodsName",required = true,dataType = "String")
    private String goodsName;
    @ApiModelProperty(value = "商品价格",name = "price",required = true,dataType = "Double")
    private Double price;
    @ApiModelProperty(value = "商品类型id",name = "goodsTypeId",required = true,dataType = "Integer")
    private Integer goodsTypeId;
    @ApiModelProperty(value = "商品图片",name = "goodsImg",required = true,dataType = "String")
    private String goodsImg;
    @ApiModelProperty(value = "商品介绍",name = "goodsImg",required = true,dataType = "String")
    private String goodsDesc;
    @ApiModelProperty(value = "商品种类id",name = "kindId",required = true,dataType = "Integer")
    private Integer kindId;
    @ApiModelProperty(value = "商品品牌id",name = "brandId",required = true,dataType = "Integer")
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