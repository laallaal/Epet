package com.qfedu.controller;

import com.qfedu.entry.Cat;
import com.qfedu.entry.Json;
import com.qfedu.entry.Order;
import com.qfedu.service.OrderService;
import com.qfedu.utils.JsonSetUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

import javax.servlet.http.HttpSession;
@Api(value = "订单请求", tags = "订单的增删改查")
@Controller
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/selectByStatuId",method = {RequestMethod.POST,RequestMethod.GET})
    @ApiOperation("查询订单，不输入参数查询全部，输入1查询待付款，输入2查询待发货，输入3查询已发货，输入4查询待评价")
    @ResponseBody
    public Json selectByStatuId(Integer statusId, HttpSession session) {
        String userName = (String) session.getAttribute("USERNAME");
        Order order = new Order();
        order.setUserName(userName);
        order.setStatusId(statusId);
        List<Order> orders = orderService.selectByAllCondition(order);
        return JsonSetUtils.getJson("1","订单列表",orders);
    }


    @RequestMapping(value = "/addOrder",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Json addOrder(Cat cat, HttpSession session){
        String username = (String) session.getAttribute("USERNAME");
        System.out.println(username);
        cat.setUName(username);

        int rows = orderService.addOrder(cat);
        if (rows > 0) {
            return JsonSetUtils.getJson("1","添加成功",null);
        }
        return JsonSetUtils.getJson("0","添加失败",null);
    }

}
