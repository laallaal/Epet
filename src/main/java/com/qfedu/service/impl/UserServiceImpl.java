package com.qfedu.service.impl;

import com.qfedu.entry.User;
import com.qfedu.mapper.UserMapper;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;



    @Override
    public boolean addUser(User user) {

        int rows = userMapper.addUser(user);

        System.out.println("userId"+rows);

        return rows > 0 ? true : false ;
    }

    @Override
    public User selectByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    @Override
    public Integer updateByUserName(User user) {
        return userMapper.updateUserByUserName(user);
    }



    @Override
    public int countByUser(User user) {


        return userMapper.countByUser (user);
    }

}
