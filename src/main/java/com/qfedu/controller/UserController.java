package com.qfedu.controller;


import com.qfedu.entry.Json;
import com.qfedu.entry.User;
import com.qfedu.service.DiscountCouponService;
import com.qfedu.service.UserService;
import com.qfedu.utils.Md5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
@Api(value = "用户操作", tags = "User操作")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    DiscountCouponService discountCouponService;


    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value = "register", notes = "用户注册", httpMethod = "GET, POST")
    public Json register(HttpServletResponse response, Model model, HttpSession session, String userName, String password) {

        User user = new User();
        user.setUserName(userName);
        user.setPassword(Md5Utils.getMd5Str(password));
        System.out.println(user.getPassword());

        boolean isAddSuccess = userService.addUser(user);

        Json json = new Json();
        if (isAddSuccess) {
            json.setMsg("注册成功");

            return json;
        }

        json.setMsg("注册失败");

        return json ;
    }


    @ResponseBody
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "login", notes = "用户登录方法", httpMethod = "GET,POST")
    public Json login(User user, HttpSession session) {
        user.setPassword (Md5Utils.getMd5Str (user.getPassword ()));
        int result = userService.countByUser (user);
        Json json = new Json();
        if (result > 0) {
            json.setMsg("登陆成功");
            session.setAttribute("USERNAME",user.getUserName());
            return json;
        }
        json.setMsg("登陆失败");
        return json;
    }



    @RequestMapping(value = "/showUser",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation("设置的信息传递")
    public Json showUser(HttpSession session) {
        String userName = (String) session.getAttribute("USERNAME");
        User user = userService.selectByUserName(userName);
        System.out.println(user);
        Json json = new Json();
        json.setData(user);
        json.setMsg("展示用户信息");
        return json;
    }

    @RequestMapping(value = "/exit",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation("退出方法，退出并删除相应信息")
    public Json exit(HttpSession session){
        session.removeAttribute("USERNAME");

        Json json = new Json();

        json.setMsg("退出成功");

        return json;

    }



    @RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation("按用户名修改用户信息")
    public Json updateByUserName(User user){

        Json json = new Json();
        Integer rows = userService.updateByUserName(user);

        if (rows > 0) {

            json.setMsg("success");

            return json;
        }

        json.setMsg("fail");

        return json;

    }

    @RequestMapping(value = "/myWallet",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation("我的钱包")
    public Json myWallet(HttpSession session) {
        session.setAttribute("USERNAME","user01");
        String userName = (String) session.getAttribute("USERNAME");
        User user = userService.selectByUserName(userName);
        Integer count = discountCouponService.selectCountByUserName(userName);
        user.setDiscountCouponCount(count);
        System.out.println(user);
        Json json = new Json();
        json.setData(user);
        json.setMsg("我的钱包");
        return json;
    }


}
