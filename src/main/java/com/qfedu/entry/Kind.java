package com.qfedu.entry;

import lombok.Data;

@Data
public class Kind {
    private Integer id;
    private String kindName;

    public Kind() {
    }

    public Kind(Integer id, String kindName) {
        this.id = id;
        this.kindName = kindName;
    }

}