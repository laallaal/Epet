package com.qfedu.entry;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String phone;
    private String nickname;
    private String sex;
    private Date birthday;
    private String addr;
    private String headImg;
    private Double money;
    private Integer petId;

    public User() {
    }

    public User(Integer id, String userName, String password, String phone, String nickname, String sex, Date birthday, String addr, String headImg, Double money, Integer petId) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.nickname = nickname;
        this.sex = sex;
        this.birthday = birthday;
        this.addr = addr;
        this.headImg = headImg;
        this.money = money;
        this.petId = petId;
    }
}