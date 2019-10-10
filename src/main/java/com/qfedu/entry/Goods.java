package com.qfedu.entry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Goods实体", description = "用于接收和传递商品信息")
public class Goods {
    private Integer id;
    @ApiModelProperty(value = "商品名称",name = "goodsName",dataType = "String")
    private String goodsName;
    @ApiModelProperty(value = "商品价格",name = "price",dataType = "Double")
    private Double price;
    @ApiModelProperty(value = "商品类型id",name = "goodsTypeId",dataType = "Integer")
    private Integer goodsTypeId;
    @ApiModelProperty(value = "商品图片",name = "goodsImg",dataType = "String")
    private String goodsImg;
    @ApiModelProperty(value = "商品介绍",name = "goodsImg",dataType = "String")
    private String goodsDesc;
    @ApiModelProperty(value = "商品种类id",name = "kindId",dataType = "Integer")
    private Integer kindId;
    @ApiModelProperty(value = "商品品牌id",name = "brandId",dataType = "Integer")
    private Integer brandId;
    private Brand brand;
    private GoodsType goodsType;

    public Goods() {
    }



}