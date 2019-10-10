package com.qfedu.entry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "cat实体", description = "用于接收和传递购物车信息")
public class Cat {
    private Integer id;
    @ApiModelProperty(value = "商品id",name = "gid",required = true,dataType = "Integer")
    private Integer gid;
    @ApiModelProperty(value = "用户名",name = "uName",required = true,dataType = "Integer")
    private String uName;
    @ApiModelProperty(value = "商品数量",name = "num",required = true,dataType = "Integer")
    private Integer num;
    @ApiModelProperty(value = "商品是否付费，付费为0，未付费为1",name = "isDelete",required = true,dataType = "Integer")
    private Integer isDelete;

    @ApiModelProperty(value = "商品",name = "goods",required = false,dataType = "Goods")
    private Goods goods;



    public Cat() {
    }

}