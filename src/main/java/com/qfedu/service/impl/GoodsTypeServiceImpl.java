package com.qfedu.service.impl;

import com.qfedu.entry.GoodsType;
import com.qfedu.service.GoodsTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Stream
 * @version 1.0
 * @date 2019/10/04 09:48
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Override
    public List<GoodsType> getGoodsTypeByParent(String parents) {
        return null;
    }
}
