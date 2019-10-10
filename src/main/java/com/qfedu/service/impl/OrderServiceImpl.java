package com.qfedu.service.impl;

import com.qfedu.entry.Cat;
import com.qfedu.entry.Order;
import com.qfedu.entry.OrderGoods;
import com.qfedu.mapper.OrderGoodsMapper;
import com.qfedu.mapper.OrderMapper;
import com.qfedu.service.OrderService;
import com.qfedu.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderGoodsMapper orderGoodsMapper;
    @Override
    public List<Order> selectByAllCondition(Order order) {
        return orderMapper.selectByAllCondition(order);
    }

    @Override
    public int addOrder(Cat cat) {
        System.out.println(cat);
        Order order = new Order();
        String uuid = UUIDUtils.getUUID();
        order.setOrderCode(uuid);
      /*  order.setTotalPrice(cat.getGoods().getPrice()*cat.getNum());*/
        order.setCreateDate(new Date());
        order.setUserName(cat.getUName());
        order.setStatusId(1);
        Integer rows = orderMapper.addOrder(order);
        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setOrderCode(uuid);
        orderGoods.setGid(cat.getGid());
        orderGoods.setNum(cat.getNum());
        Integer rows2 = orderGoodsMapper.addOrderGoods(orderGoods);
        return 1;
    }
}
