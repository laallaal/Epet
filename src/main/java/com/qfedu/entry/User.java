package com.qfedu.entry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "user实体", description = "用于接收和传递用户信息")
public class User {
    private Integer id;
    @ApiModelProperty(value = "用户名",name = "userName",dataType = "String")
    private String userName;
    @ApiModelProperty(value = "密码",name = "password",dataType = "String")
    private String password;
    @ApiModelProperty(value = "手机号",name = "phone",dataType = "String")
    private String phone;
    @ApiModelProperty(value = "昵称",name = "nickname",dataType = "String")
    private String nickname;
    @ApiModelProperty(value = "性别",name = "sex",dataType = "String")
    private String sex;
    @ApiModelProperty(value = "出生日期",name = "birthday",dataType = "Date")
    private Date birthday;
    @ApiModelProperty(value = "地址",name = "addr",dataType = "String")
    private String addr;
    @ApiModelProperty(value = "头像",name = "headImg",dataType = "String")
    private String headImg;
    @ApiModelProperty(value = "金额",name = "money",dataType = "Double")
    private Double money;
    @ApiModelProperty(value = "宠物id",name = "petId",dataType = "Integer")
    private Integer petId;

    @ApiModelProperty(value = "E宠币",name = "eMoney",dataType = "Double")
    private Double eMoney;
    @ApiModelProperty(value = "红包",name = "redPacket",dataType = "Double")
    private Double redPacket;
    @ApiModelProperty(value = "关注品牌",name = "brands",dataType = "List<Brand>")
    private List<Brand> brands;
    @ApiModelProperty(value = "关注品牌id",name = "bids",dataType = "List<Integer>")
    private List<Integer> bids;
    @ApiModelProperty(value = "优惠券个数",name = "discountCouponCount",dataType = "Integer")
    private Integer discountCouponCount;

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