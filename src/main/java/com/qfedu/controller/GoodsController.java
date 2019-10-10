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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
@Controller
@RequestMapping("/goods")
@Api(value = "商品查询", tags = "各种条件查询展示方法")
public class GoodsController {


    @Autowired
    BrandService brandService;
    @Autowired
    GoodsService goodsService;




    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
    @RequestMapping(value = "/showGoodsTypeRecently", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation(value = "showGoodsTypeRecently", notes = "最近浏览商品类型", httpMethod = "GET, POST")
    public Json showGoodsTypeRecently(HttpServletRequest request, HttpServletResponse response) {

        Json json = new Json();

        Cookie[] cookies = request.getCookies();

        List<GoodsType> goodsTypeListRecently = new ArrayList<>();


        for (int i = cookies.length - 1 ; i >= 0 && i > cookies.length - 8 ; i--) {

            String typeId = cookies[i].getValue();

            if (typeId.length() < 5) {

                System.out.println("typeId:::"+typeId);

                GoodsType goodsType = goodsService.selectGoodsTypeByGoodsTypeId(Integer.valueOf(typeId));

                System.out.println("goodsType:::::::"+goodsType);

                goodsTypeListRecently.add(goodsType);
            }
        }


        json.setMsg("最近浏览商品类型ID");
        json.setData(goodsTypeListRecently);

        /* model.addAttribute("goodsTypeListRecently",goodsTypeListRecently);*/

        return json;
    }





    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
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



    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
    @RequestMapping(value = "/queryGoodsListByInput",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value = "queryGoodsListByInput", notes = "输入查询商品方法，可以查询品牌、类型、商品名称", httpMethod = "GET,POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsName", value = "用户输入信息", required = false, dataType = "String")
    })
    public Json queryGoodsListByInput(String goodsName) {
        Json json = new Json();

        if (goodsName != null) {
            System.out.println("1111111111111111111111");
            System.out.println(goodsName);

            List<Goods> goodsList = goodsService.selectGoodsBySelective(goodsName);

            if (goodsList != null) {
                json.setMsg("用户搜索-商品展示");
                json.setData(goodsList);
                return json;
            }
        } else {
            List<Goods> goodsList = goodsService.selectAllGoods();

            json.setMsg("展示所有商品");
            json.setData(goodsList);
            return json;
        }



        json.setMsg("查询失败");
        return json;
    }

    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
    @RequestMapping(value = "/queryGoodsListByClickTypeId",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value = "queryGoodsListByClickTypeId", notes = "点击查询商品方法，可以查询品牌、类型、商品名称", httpMethod = "GET,POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typeId", value = "商品类型id", required = false, dataType = "Integer")
    })
    public Json queryGoodsListByClickTypeId(HttpServletResponse response, Integer typeId) {
        Json json = new Json();

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



    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
    @RequestMapping(value = "/queryGoodsListByClickBrandId",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @ApiOperation(value = "queryGoodsListByClickBrandId", notes = "点击查询商品方法，可以查询品牌、类型、商品名称", httpMethod = "GET,POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "brandId", value = "商品品牌id", required = false, dataType = "Integer")
    })
    public Json queryGoodsListByClickBrandId(HttpServletResponse response, Integer brandId) {
        Json json = new Json();
        if (brandId != null) {
            List<Brand> brand = brandService.selectBrandById (brandId);

            json.setMsg("点击商品品牌查询");
            json.setData(brand);
            //model.addAttribute ("", brand);
            return json;
        }


        json.setMsg("查询失败");
        return json;
    }

    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
    @ResponseBody
    @RequestMapping(value = "/particulars",method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "particulars", notes = "点击商品展示商品详情", httpMethod = "GET, POST")
    public Json particulars (Integer id){
        Json json = new Json ();
        Goods goods = goodsService.selectGoodsById(id);
        System.out.println (goods);
        if (goods.getId () != 0){
            json.setData(goods);
            System.out.println ("111");
            System.out.println (json.getData());
            json.setMsg ("展示点击的商品");
            return json;
        }
        json.setMsg ("商品不存在");
        return json;
    }



    @RequestMapping(value = "/showGoodsList", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation(value = "showGoodsList", notes = "展示所有商品", httpMethod = "GET, POST")
    public Json showGoodsList() {

        Json json = new Json();

        List<Goods> goodsList = goodsService.selectAllGoods();

        json.setMsg("展示所有商品");
        json.setData(goodsList);
        return json;


    }


    @RequestMapping(value = "/showTypeByDirectory" , method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation(value = "showTypeByDirectory", notes = "根据左边目录展示相应的商品类型", httpMethod = "GET, POST")
    public Json showTypeByDirectory(int directoryId ) {

        Json json = new Json();

        List<GoodsType> goodsTypeList = goodsService.selectAllGoodsTypeByDirectoryId(directoryId);


        json.setMsg("根据左边目录展示相应的商品类型");
        json.setData(goodsTypeList);

        return json;


    }





    @RequestMapping(value = "/showBrandByDirectory" , method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    @ApiOperation(value = "showBrandByDirectory", notes = "根据左边目录展示相应的品牌", httpMethod = "GET, POST")

    public Json showBrandByDirectory( int directoryId ) {

        Json json = new Json();

        List<GoodsType> BrandList = brandService.selectAllBrandIdByDirectoryId(directoryId);


        json.setMsg("根据左边目录展示相应的品牌");
        json.setData(BrandList);

        return json;


    }


}
