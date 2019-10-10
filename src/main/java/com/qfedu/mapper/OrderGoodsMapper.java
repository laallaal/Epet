package com.qfedu.mapper;

import com.qfedu.entry.Cat;
import com.qfedu.entry.OrderGoods;
import java.util.*;

public interface OrderGoodsMapper {
    List<OrderGoods> selectByOrderCode(String orderCoder);

    Integer addOrderGoods(OrderGoods orderGoods);
}
