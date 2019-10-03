package com.qfedu.service;


import com.qfedu.entry.User;

public interface UserService {


    boolean addUser(User user);

    User selectByUserName(String userName);
}
