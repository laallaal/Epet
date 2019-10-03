package com.qfedu.entry;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Integer id;
    private String orderCode;
    private Double totalPrice;
    private Date createDate;
    private Integer uid;
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