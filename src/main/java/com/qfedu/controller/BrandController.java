package com.qfedu.controller;

import com.qfedu.entry.Brand;
import com.qfedu.entry.User;
import com.qfedu.service.AttentionService;
import com.qfedu.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
@RequestMapping("/brand")
@Api(value = "品牌方法", tags = "品牌的增删改查")
public class BrandController {
    @Autowired
    BrandService brandService;
    @Autowired
    AttentionService attentionService;

    @ApiOperation("查询所有品牌的信息")
    @RequestMapping(value = "selectBrandAll",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<Brand> selectBrandAll() {
        List<Brand> brands = brandService.selectBrandAll();
        System.out.println(brands);
        return brands;
    }

    @ApiOperation("我关注的品牌")
    @RequestMapping(value = "/myAttention", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    private List<Brand> myAttention(HttpSession session) {
        String userName = (String) session.getAttribute("USERNAME");
        List<Integer> bidList = attentionService.selectByUserName(userName);
        User user = new User();
        user.setBids(bidList);

        List<Brand> brands= brandService.selectBatchByBrandId(user);
        return brands;
    }
}
