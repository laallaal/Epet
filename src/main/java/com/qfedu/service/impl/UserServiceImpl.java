package com.qfedu.service.impl;

<<<<<<< HEAD

=======
>>>>>>> origin/master
import com.qfedu.mapper.UserMapper;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    @Override
    public User selectByUserName(String userName) {
        return mapper.selectByUserName(userName);
=======

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public boolean addUser(User user) {

        int rows = userMapper.addUser(user);

        System.out.println("userId"+rows);

        return rows > 0 ? true : false ;
>>>>>>> origin/master
    }
}
