package com.qfedu.controller;


import com.qfedu.entry.User;
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


    @RequestMapping(value = "/showUser",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation("设置信息传递")
    public User showUser(HttpSession session) {

        String userName = (String) session.getAttribute("USERNAME");
        User user = userService.selectByUserName(userName);
        System.out.println(user);
        return user;
    }

    /*@RequestMapping("/exit")
    @ResponseBody
    @ApiOperation("退出方法，退出并删除相应信息")
    public void exit(HttpSession session){
        session.removeAttribute("USERNAME");
    }
*/

}
