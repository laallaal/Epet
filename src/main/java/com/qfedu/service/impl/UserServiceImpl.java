package com.qfedu.service.impl;




import com.qfedu.entry.User;
import com.qfedu.mapper.UserMapper;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
<<<<<<< HEAD


=======
>>>>>>> origin/master
    @Autowired
    UserMapper mapper;

    @Override
<<<<<<< HEAD
    public boolean addUser(User user) {
        int rows = mapper.addUser(user);

        System.out.println("userId"+rows);

        return rows > 0 ? true : false ;

    }

    @Override
    public User selectByUserName(String userName) {
        return mapper.selectByUserName(userName);





=======
    public User selectByUserName(String userName) {
        return mapper.selectByUserName(userName);
>>>>>>> origin/master
    }

}
