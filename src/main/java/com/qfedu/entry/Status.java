package com.qfedu.entry;

import lombok.Data;

@Data
public class Status {
    private Integer id;
    private String orderStatus;

    public Status() {
    }

    public Status(Integer id, String orderStatus) {
        this.id = id;
        this.orderStatus = orderStatus;
    }

}