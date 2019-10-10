package com.qfedu.entry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;

import java.util.Date;

@Data
@ApiModel(value = "order实体", description = "用于接收和传递订单信息")
public class Order {
    private Integer id;
    @ApiModelProperty(value = "订单编号",name = "orderCode",dataType = "String")
    private String orderCode;
    @ApiModelProperty(value = "总价格",name = "totalPrice", dataType = "String")
    private Double totalPrice;
    @ApiModelProperty(value = "下单时间",name = "createDate",dataType = "Date")
    private Date createDate;
    @ApiModelProperty(value = "用户名",name = "userName",dataType = "String")
    private String userName;
    @ApiModelProperty(value = "状态id",name = "statusId",dataType = "Integer")
    private Integer statusId;
    @ApiModelProperty(value = "订单商品",name = "orderGoods",dataType = "List<OrderGoods>")
    private List<OrderGoods> orderGoods;
    public Order() {
    }


}