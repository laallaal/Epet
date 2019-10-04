package com.qfedu.controller;


import com.qfedu.entry.GoodsType;
import com.qfedu.service.GoodsService;
import com.qfedu.utils.BrowsingHistory;
import com.qfedu.utils.HotGoodsType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/goods")
@Api(value = "商品查询", tags = "各种条件查询展示方法")
public class GoodsController {

    @Autowired
    GoodsService goodsService;


    @RequestMapping(value = "/showGoodsTypeRecently", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation(value = "showGoodsTypeRecently", notes = "最近浏览商品类型", httpMethod = "GET, POST")
    public String showGoodsTypeRecently(Model model, HttpServletRequest request, HttpServletResponse response) {

        BrowsingHistory.addCookie(response,"1","111", 60*5);
        BrowsingHistory.addCookie(response,"2","222", 60*5);
        BrowsingHistory.addCookie(response,"3","333", 60*5);
        BrowsingHistory.addCookie(response,"4","444", 60*5);

        Cookie[] cookies = request.getCookies();
        //System.out.println("length--:"+cookies.length);


        List<GoodsType> goodsTypeListRecently = new ArrayList<>();

        System.out.println("22222222222222222");



        for (int i = cookies.length - 1 ; i >= 0 && i > cookies.length - 6 ; i--) {



            System.out.println("lalalalalalalal");

            String typeName = cookies[i].getValue();

            System.out.println("typeName:::"+typeName);

            GoodsType goodsType = goodsService.selectGoodsTypeByGoodsTypeName(typeName);

            goodsTypeListRecently.add(goodsType);

        }

        model.addAttribute("goodsTypeListRecently",goodsTypeListRecently);

        return "success";
    }



    @RequestMapping(value = "/showGoodsTypeHot", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation(value = "showGoodsTypeHot", notes = "最火爆的商品类型", httpMethod = "GET, POST")
    public String showGoodsTypeHot(Model model) {

        List<GoodsType> goodsTypeList = goodsService.selectAllGoodsType();

        List<GoodsType> typeList = HotGoodsType.selectHotGoodsType(goodsTypeList);

        model.addAttribute("goodsTypeList", typeList);

        return "success";

    }




}
