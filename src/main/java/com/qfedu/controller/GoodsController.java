package com.qfedu.controller;


import com.qfedu.entry.Brand;
import com.qfedu.entry.Goods;
import com.qfedu.entry.GoodsType;
import com.qfedu.entry.Json;
import com.qfedu.service.BrandService;
import com.qfedu.service.GoodsService;
import com.qfedu.utils.BrowsingHistory;
import com.qfedu.utils.HotGoodsType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/goods")
@Api(value = "商品查询", tags = "各种条件查询展示方法")
public class GoodsController {


    @Autowired
    BrandService brandService;


    @Autowired
    GoodsService goodsService;


    @RequestMapping(value = "/showGoodsTypeRecently", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation(value = "showGoodsTypeRecently", notes = "最近浏览商品类型", httpMethod = "GET, POST")
    public Json showGoodsTypeRecently(Model model, HttpServletRequest request, HttpServletResponse response) {

        Json json = new Json();
       /* BrowsingHistory.addCookie(response,"1","111", 60*5);
        BrowsingHistory.addCookie(response,"2","222", 60*5);
        BrowsingHistory.addCookie(response,"3","333", 60*5);
        BrowsingHistory.addCookie(response,"4","444", 60*5);*/

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

        json.setMsg("最近浏览商品类型");
        json.setData(goodsTypeListRecently);

       /* model.addAttribute("goodsTypeListRecently",goodsTypeListRecently);*/

        return json;
    }



    @RequestMapping(value = "/showGoodsTypeHot", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation(value = "showGoodsTypeHot", notes = "最火爆的商品类型", httpMethod = "GET, POST")
    public Json showGoodsTypeHot(Model model) {

        Json json = new Json();
        List<GoodsType> goodsTypeList = goodsService.selectAllGoodsType();

        List<GoodsType> typeList = HotGoodsType.selectHotGoodsType(goodsTypeList);

        json.setMsg("展示最火爆的商品类型");
        json.setData(typeList);
       /* model.addAttribute("goodsTypeList", typeList);*/

        return json;

    }




    @RequestMapping(value = "/query",method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "query", notes = "输入查询商品方法，可以查询品牌、类型、商品名称", httpMethod = "GET,POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "input", value = "用户输入信息", required = false, dataType = "String")
    })
    public Json query(String input) {
        Json json = new Json();
        List<Goods> goodsList = goodsService.selectGoodsBySelective(input);

        if (goodsList != null) {
            json.setMsg("用户搜索-商品展示");
            json.setData(goodsList);
            return json;
        }

        json.setMsg("查询失败");
        return json;
    }


    @RequestMapping(value = "/queryGoods",method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "query", notes = "点击查询商品方法，可以查询品牌、类型、商品名称", httpMethod = "GET,POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "brandId", value = "品牌id", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "typeId", value = "商品类型id", required = false, dataType = "Integer")
    })
    public Json queryGoods(Model model, HttpServletResponse response, Integer brandId, Integer typeId) {
        Json json = new Json();
        if (brandId != null) {
            List<Brand> brand = brandService.selectBrandById (brandId);

            json.setMsg("点击商品品牌查询");
            json.setData(brand);
            //model.addAttribute ("", brand);
            return json;
        }
        if (typeId != null) {
            List<Goods> goodsList = goodsService.queryGoodsByTypeId (typeId);
            String value = String.valueOf (typeId);
            BrowsingHistory.addCookie (response,value,value,10000);

            json.setMsg("点击商品类型查询");
            json.setData(goodsList);
            /*model.addAttribute ("", goodsList);*/
            return json;
        }

        json.setMsg("查询失败");
        return json;
    }







}
