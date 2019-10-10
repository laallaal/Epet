package com.qfedu.mapper;

import com.qfedu.entry.Pet;

/**
 * @author Stream
 * @version 1.0
 * @date 2019/10/06 11:14
 */
public interface PetMapper {
    Pet selectPetByUserName(String userName);

    int updatePetBySelective(Pet pet);
}
