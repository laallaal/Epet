package com.qfedu.mapper;

import com.qfedu.entry.User;

public interface UserMapper {
    public int updateUserByUserName(User user);

    User selectByUserName(String userName);
}
