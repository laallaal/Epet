package com.qfedu.mapper;

import java.util.List;

public interface AttentionMapper {
    List<Integer> selectByUserName(String userName);
    Integer selectByBid(Integer bid);
}
