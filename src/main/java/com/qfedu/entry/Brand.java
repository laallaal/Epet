package com.qfedu.entry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "brand实体", description = "用于接收和传递品牌信息")
public class Brand {
    private Integer id;
    @ApiModelProperty(value = "品牌名称",name = "brandName",required = true,dataType = "String")
    private String brandName;
    @ApiModelProperty(value = "品牌简介",name = "brandDesc",required = true,dataType = "String")
    private String brandDesc;
    @ApiModelProperty(value = "品牌关注量",name = "attention",required = false,dataType = "Integer")
    private Integer attention;

    public Brand() {
    }

    public Brand(Integer id, String brandName, String brandDesc, Integer attention) {
        this.id = id;
        this.brandName = brandName;
        this.brandDesc = brandDesc;
        this.attention = attention;
    }

}