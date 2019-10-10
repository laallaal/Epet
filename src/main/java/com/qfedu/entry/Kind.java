package com.qfedu.entry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Kind实体", description = "用于接收和传递宠物种类信息")
public class Kind {
    private Integer id;
    @ApiModelProperty(value = "种类名称",name = "kindName",dataType = "String")
    private String kindName;

    public Kind() {
    }

    public Kind(Integer id, String kindName) {
        this.id = id;
        this.kindName = kindName;
    }

}