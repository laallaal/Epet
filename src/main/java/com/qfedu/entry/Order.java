package com.qfedu.entry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "order实体", description = "用于接收和传递订单信息")
public class Order {
    private Integer id;
    @ApiModelProperty(value = "订单编号",name = "orderCode",required = true,dataType = "String")
    private String orderCode;
    @ApiModelProperty(value = "总价格",name = "totalPrice",required = true,dataType = "String")
    private Double totalPrice;
    @ApiModelProperty(value = "下单时间",name = "createDate",required = true,dataType = "Date")
    private Date createDate;
    @ApiModelProperty(value = "用户id",name = "uid",required = true,dataType = "Integer")
    private Integer uid;
    @ApiModelProperty(value = "状态id",name = "statusId",required = true,dataType = "Integer")
    private Integer statusId;

    public Order() {
    }

    public Order(Integer id, String orderCode, Double totalPrice, Date createDate, Integer uid, Integer statusId) {
        this.id = id;
        this.orderCode = orderCode;
        this.totalPrice = totalPrice;
        this.createDate = createDate;
        this.uid = uid;
        this.statusId = statusId;
    }

}