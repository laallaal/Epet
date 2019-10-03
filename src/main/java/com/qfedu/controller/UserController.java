package com.qfedu.controller;

import com.qfedu.service.UserService;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/showUser",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation("设置信息传递")
    public User showUser(HttpSession session) {

        String userName = (String) session.getAttribute("USERNAME");
        User user = userService.selectByUserName(userName);
        System.out.println(user);
        return user;
    }

    @RequestMapping("/exit")
    @ResponseBody
    @ApiOperation("退出方法，退出并删除相应信息")
    public void exit(HttpSession session){
       session.removeAttribute("USERNAME");
    }


}
