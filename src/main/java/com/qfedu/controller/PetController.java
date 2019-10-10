package com.qfedu.controller;

import com.qfedu.entry.Json;
import com.qfedu.entry.Pet;
import com.qfedu.service.PetService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Stream
 * @version 1.0
 * @date 2019/10/06 11:02
 */
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
@Controller
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;


    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
    @ResponseBody
    @RequestMapping(value = "/jump", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "jump", notes = "跳转至宠物编辑页面", httpMethod = "GET,POST")
    public Json jump(HttpSession session) {
        Json json = new Json();
       /* session.setAttribute ("userName", "user01");*/
        String userName = (String) session.getAttribute ("userName");
        System.out.println (userName);
        Pet pet = petService.selectPetByUserName (userName);
        System.out.println (pet);
        if (pet.getId () != null) {
            json.setMsg ("查询到" + userName + "的宠物");
            json.setData (pet);
            System.out.println (json);
            return json;
        }
        json.setMsg ("查询结果为空");
        return json;
    }



    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
    @ResponseBody
    @RequestMapping(value = "/editPet", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "editPet", notes = "编辑宠物页面", httpMethod = "GET,POST")
    public Json editPet(Pet pet) {
        Json json = new Json();
        int result = petService.updatePetBySelective (pet);
        if (result > 0) {
            json.setMsg ("修改宠物信息成功");
            return json;
        }
        json.setMsg ("修改宠物信息失败");
        return json;
    }
}
