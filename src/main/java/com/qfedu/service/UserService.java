package com.qfedu.service;

import com.qfedu.entry.User;

public interface UserService {


    boolean addUser(User user);

    public User selectByUserName(String userName);

    Integer updateByUserName(User user);


    int countByUser(User user);
}



