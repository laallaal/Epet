package com.qfedu.mapper;


import com.qfedu.entry.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;

public interface UserMapper {


    @Results(id = "userMap" ,
            value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userName", column = "userName"),
            @Result(property = "password", column = "password"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "addr", column = "addr"),
            @Result(property = "headImg", column = "headImg"),
            @Result(property = "money", column = "money"),

            }
    )
    @Insert("insert into user(userName,password) values(#{userName}, #{password})")
    @SelectKey(keyColumn = "id",keyProperty = "id",resultType = Integer.class, before = false, statement = {"select last_insert_id()"})
    int addUser(User user);



}
