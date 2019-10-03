package com.qfedu.entry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "pet实体", description = "用于接收和传递宠物信息")
public class Pet {
    private Integer id;
    @ApiModelProperty(value = "宠物名称",name = "petName",required = true,dataType = "String")
    private String petName;
    @ApiModelProperty(value = "宠物性别",name = "sex",required = true,dataType = "String")
    private String sex;
    @ApiModelProperty(value = "宠物种类",name = "kindName",required = true,dataType = "String")
    private String kindName;
    @ApiModelProperty(value = "宠物出生日期",name = "birthday",required = true,dataType = "Date")
    private Date birthday;
    @ApiModelProperty(value = "宠物打疫苗时间",name = "vaccineTime",required = false,dataType = "Date")
    private Date vaccineTime;

    public Pet() {
    }

    public Pet(Integer id, String petName, String sex, String kindName, Date birthday, Date vaccineTime) {
        this.id = id;
        this.petName = petName;
        this.sex = sex;
        this.kindName = kindName;
        this.birthday = birthday;
        this.vaccineTime = vaccineTime;
    }

}