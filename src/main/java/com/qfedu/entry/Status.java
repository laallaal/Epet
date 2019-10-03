package com.qfedu.entry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "pet实体", description = "用于接收和传递订单状态信息")
public class Status {
    private Integer id;
    @ApiModelProperty(value = "订单状态",name = "orderStatus",required = true,dataType = "String")
    private String orderStatus;

    public Status() {
    }

    public Status(Integer id, String orderStatus) {
        this.id = id;
        this.orderStatus = orderStatus;
    }

}