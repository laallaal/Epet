package com.qfedu.service;

import com.qfedu.entry.Pet;

/**
 * @author Stream
 * @version 1.0
 * @date 2019/10/06 11:04
 */
public interface PetService {

    Pet selectPetByUserName(String userName);

    int updatePetBySelective(Pet pet);
}
