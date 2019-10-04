package com.qfedu.service.impl;

import com.qfedu.mapper.DiscountCouponMapper;
import com.qfedu.service.DiscountCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountCouponServiceImpl implements DiscountCouponService {
    @Autowired
    DiscountCouponMapper mapper;
    @Override
    public Integer selectCountByUserName(String userName) {
        return mapper.selectCountByUserName(userName);
    }
}
