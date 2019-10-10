package com.qfedu.entry;

import lombok.Data;

@Data
public class OrderGoods {
    private Integer id;

    private String orderCode;

    private Integer gid;
    private Integer num;
    private Goods goods;
}