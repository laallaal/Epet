package com.qfedu.mapper;

import com.qfedu.entry.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> selectByAllCondition(Order order);

    Integer addOrder(Order order);

}
