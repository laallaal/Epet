package com.qfedu.mapper;


import com.qfedu.entry.User;

public interface UserMapper {
    User selectByUserName(String userName);

}
