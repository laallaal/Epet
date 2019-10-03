package com.qfedu.entry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GoodsType实体", description = "用于接收和传递商品类型信息")
public class GoodsType {
    private Integer id;
    @ApiModelProperty(value = "商品类型",name = "typeName",required = true,dataType = "String")
    private String typeName;

    public GoodsType() {
    }

    public GoodsType(Integer id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

}