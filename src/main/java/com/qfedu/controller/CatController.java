package com.qfedu.controller;

import com.qfedu.entry.Cat;
import com.qfedu.entry.Json;
import com.qfedu.service.CatService;
import com.qfedu.utils.JsonSetUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
@Controller
@Api(value = "购物车的方法", tags = "购物车的增删改查")
@RequestMapping("/cat")
public class CatController {
    @Autowired
    CatService catService;
    @RequestMapping(value = "/showMyCat",method = {RequestMethod.POST,RequestMethod.GET})
    @ApiOperation("该用户购物车的保存的商品")

    @ResponseBody
    public Json showMyCat(HttpSession session){
        String uName = (String) session.getAttribute("USERNAME");
        System.out.println(uName);
        List<Cat> cats = catService.selectByUName(uName);
        return JsonSetUtils.getJson("1","该用户购物车的保存的商品",cats);
    }


    @RequestMapping(value = "/addGoodsToCat",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation("添加商品到购物车")
    public Json addGoodsToCat(Integer gid, HttpSession session){
        String uName = (String) session.getAttribute("USERNAME");
        Cat cat = new Cat();
        cat.setGid(gid);
        cat.setUName(uName);
        Integer rows = catService.selectByUNameAndGid(cat);
        System.out.println(rows);
        if (rows > 0) {
            Json json = updateCatByAddNum(gid, session);
            return json;
        }
        Integer rows2 = catService.addGoodsToCat(cat);
        if (rows2 > 0){
            return JsonSetUtils.getJson("1","添加商品到购物车", "购物车无该商品，向购物车添加该商品");
        }
        return JsonSetUtils.getJson("0","添加商品失败",null);
    }


    @RequestMapping(value = "/updateCatByAddNum",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation(value = "updateCatByAddNum", notes = "点击+号数量加一", httpMethod = "GET, POST")
    public Json updateCatByAddNum(int goodsId, HttpSession session) {
        Json json = new Json();

        String userName = (String) session.getAttribute("USERNAME");

        //String userName = "user01";

        Cat cat = new Cat();
        cat.setGid(goodsId);
        cat.setUName(userName);
        boolean isAdd = catService.updateCatByAddNum(cat);

        if (isAdd) {

            json.setMsg("购物车商品+1成功");
            return json;

        }
        json.setMsg("购物车商品+1失败");
        return json;
    }

    @RequestMapping(value = "/updateCatByDeleteNum" ,method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value = "updateCatByDeleteNum", notes = "点击-号数量减一", httpMethod = "GET, POST")
    public Json updateCatByDeleteNum(int goodsId, HttpSession session) {
        Json json = new Json();

        String userName = (String) session.getAttribute("USERNAME");

        Cat cat = new Cat();
        cat.setGid(goodsId);
        cat.setUName(userName);

        boolean isAdd = catService.updateCatByDeleteNum(cat);

        if (isAdd) {
            json.setMsg("购物车商品-1成功");
            return json;

        }

        json.setMsg("购物车商品-1失败");
        return json;
    }

    @RequestMapping(value = "/updateCatByInputNum" ,method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value = "updateCatByInputNum", notes = "通过输入来修改商品数量", httpMethod = "GET, POST")
    public Json updateCatByInputNum(int goodsId, HttpSession session, int num) {
        Json json = new Json();

        String userName = (String) session.getAttribute("USERNAME");
        Cat cat = new Cat();
        cat.setGid(goodsId);
        cat.setUName(userName);
        cat.setNum(num);

        boolean isAdd = catService.updateCatByInputNum(cat);

        if (isAdd) {
            json.setMsg("购物车商品手动输入数量修改成功");
            return json;

        }

        json.setMsg("购物车商品手动输入数量修改失败");
        return json;
    }

    @RequestMapping(value = "/deleteGoodsOnCatByGoodsId" ,method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value = "deleteGoodsOnCatByGoodsId", notes = "删除购物车商品", httpMethod = "GET, POST")
    public Json deleteGoodsOnCatByGoodsId(int goodsId, HttpSession session, int num) {
        Json json = new Json();

        String userName = (String) session.getAttribute("USERNAME");

        Cat cat = new Cat();
        cat.setGid(goodsId);
        cat.setUName(userName);
        cat.setNum(num);

        boolean isDelete = catService.deleteGoodsOnCatByGoodsId(cat);

        if (isDelete) {
            json.setMsg("删除购物车商品成功");
            return json;

        }

        json.setMsg("删除购物车商品失败");
        return json;

    }
}

