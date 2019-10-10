package com.qfedu.controller;


import com.qfedu.entry.Json;
import com.qfedu.entry.User;
import com.qfedu.service.DiscountCouponService;
import com.qfedu.service.UserService;
import com.qfedu.utils.JsonSetUtils;
import com.qfedu.utils.Md5Utils;
import com.qfedu.utils.PhoneCode;
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


@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
@Controller
@RequestMapping("/user")
@Api(value = "用户操作", tags = "User操作")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    DiscountCouponService discountCouponService;

    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
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
            json.setCode("1");
            json.setMsg("注册成功");
            return json;
        }

        json.setMsg("注册失败");
        json.setCode("0");

        return json ;
    }
    @RequestMapping(value = "/loginState",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Json loginState(HttpSession session) {
        Object username = session.getAttribute("USERNAME");
        if (username != null) {
            return JsonSetUtils.getJson("1",username + "在线",null);
        }
        return JsonSetUtils.getJson("0","离线",null);

    }

    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
    @ResponseBody
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "login", notes = "用户登录方法", httpMethod = "GET,POST")
    public Json login(User user, HttpSession session) {



        user.setPassword (Md5Utils.getMd5Str (user.getPassword ()));
        int result = userService.countByUser (user);
        Json json = new Json();
        if (result > 0) {

            String userName = user.getUserName();
            session.setAttribute("USERNAME",userName);
            System.out.println(session.getAttribute("USERNAME"));
            json.setCode("1");
            json.setMsg("登陆成功");
            return json;
        }

        json.setMsg("登陆失败");
        json.setCode("0");


        return json;
    }


    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
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


    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
    @RequestMapping(value = "/exit",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation("退出方法，退出并删除相应信息")
    public Json exit(HttpSession session){
        session.removeAttribute("USERNAME");

        Json json = new Json();

        json.setMsg("退出成功");

        return json;

    }


    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
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



    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
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



    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
    @RequestMapping(value = "/verificationPhone",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation("手机验证")
    public Json  verificationPhone(HttpSession session,String phone){

        String code = PhoneCode.build(phone);
        session.setAttribute("code",code);
        Json json = new Json();
        json.setCode("1");
        json.setMsg("发送成功");
        json.setData("验证码为" + code);
        return json;
    }

    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
    @RequestMapping(value = "/verificationCode",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation("验证码校验")
    public Json  verificationCode(HttpSession session,String code){
        Json json = new Json();
        String attribute = (String) session.getAttribute("code");

        System.out.println(attribute);
        if (code.equals(attribute)){

            json.setCode("1");
            json.setMsg("验证成功");
            return json;
        }else {
            json.setCode("0");
            json.setMsg("验证失败，请重新输入");
            return json;
        }
    }



}
