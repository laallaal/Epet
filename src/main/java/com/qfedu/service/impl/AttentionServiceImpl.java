package com.qfedu.service.impl;

import com.qfedu.mapper.AttentionMapper;
import com.qfedu.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttentionServiceImpl implements AttentionService {
    @Autowired
    AttentionMapper mapper;

    @Override
    public List<Integer> selectByUserName(String userName) {
        return mapper.selectByUserName(userName);

    }
}
