package com.qfedu.controller;


import com.qfedu.service.UserService;
import com.qfedu.utils.Md5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
@Api(value = "用户操作", tags = "User操作")
public class UserController {


    @Autowired
    UserService userService;


    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value = "register", notes = "用户注册", httpMethod = "GET, POST")
    public String register(Model model, HttpSession session, String userName, String password) {

        User user = new User();
        user.setUserName(userName);
        user.setPassword(Md5Utils.getMd5Str(password));

        System.out.println(user.getPassword());

        boolean isAddSuccess = userService.addUser(user);

        /*session.setAttribute("USERNAME", userName);*/

        return "login.html";
    }






























}
