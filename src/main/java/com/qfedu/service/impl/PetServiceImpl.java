package com.qfedu.service.impl;

import com.qfedu.entry.Pet;
import com.qfedu.mapper.PetMapper;
import com.qfedu.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Stream
 * @version 1.0
 * @date 2019/10/06 11:13
 */
@Service
public class PetServiceImpl implements PetService {
    @Autowired
    PetMapper petMapper;

    @Override
    public Pet selectPetByUserName(String userName) {
        return petMapper.selectPetByUserName(userName);
    }

    @Override
    public int updatePetBySelective(Pet pet) {
        return petMapper.updatePetBySelective(pet);
    }
}
