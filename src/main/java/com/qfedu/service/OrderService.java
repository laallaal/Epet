package com.qfedu.service;

import com.qfedu.entry.Cat;
import com.qfedu.entry.Order;

import java.util.List;

public interface OrderService {
    List<Order> selectByAllCondition(Order order);

    int addOrder(Cat cat);
}
