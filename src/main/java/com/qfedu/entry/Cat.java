package com.qfedu.entry;

import lombok.Data;

@Data
public class Cat {
    private Integer id;
    private Integer gid;
    private Integer uid;
    private Integer num;
    private Integer isDelete;

    public Cat() {
    }

    public Cat(Integer id, Integer gid, Integer uid, Integer num, Integer isDelete) {
        this.id = id;
        this.gid = gid;
        this.uid = uid;
        this.num = num;
        this.isDelete = isDelete;
    }

}