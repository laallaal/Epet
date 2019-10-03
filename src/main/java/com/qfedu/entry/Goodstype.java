package com.qfedu.entry;

import lombok.Data;

@Data
public class Goodstype {
    private Integer id;
    private String typeName;

    public Goodstype() {
    }

    public Goodstype(Integer id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

}