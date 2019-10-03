package com.qfedu.entry;

import lombok.Data;

@Data
public class Brand {
    private Integer id;
    private String brandName;
    private String brandDesc;
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