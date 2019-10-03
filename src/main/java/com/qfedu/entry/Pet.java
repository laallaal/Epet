package com.qfedu.entry;

import lombok.Data;

import java.util.Date;

@Data
public class Pet {
    private Integer id;
    private String petName;
    private String sex;
    private String kindName;
    private Date birthday;
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