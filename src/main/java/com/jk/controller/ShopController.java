package com.jk.controller;

import com.jk.pojo.BrandBean;
import com.jk.pojo.ShopBean;
import com.jk.pojo.SizeBean;
import com.jk.pojo.TypeBean;
import com.jk.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-12 17:06
 */
@Controller
@RequestMapping("shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    /**
     * @Author lh 
     * @Description  上架商品查询
     * @Date 17:09 2021/1/12
     * @Param [page, rows, shopBean]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("initShopTable")
    @ResponseBody
    public HashMap<String, Object> initShopTable(Integer page, Integer rows, ShopBean shopBean){
        return shopService.initShopTable(page,rows,shopBean);
    }

    /**
     * @Author lh
     * @Description  商品尺码查询
     * @Date 17:33 2021/1/12
     * @Param [page, rows, shopBean]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("initSizeTable")
    @ResponseBody
    public HashMap<String, Object> initSizeTable(Integer id,Integer page, Integer rows,  SizeBean sizeBean){
        return shopService.initSizeTable(id,page,rows,sizeBean);
    }


    /**
     * @Author lh 
     * @Description  新增商品
     * @Date 18:59 2021/1/12
     * @Param [shopBean]
     * @return void
     **/
    @RequestMapping("addShop")
    @ResponseBody
    public void addShop(ShopBean shopBean){
        shopService.addShop(shopBean);
    }
    /**
     * @Author lh
     * @Description  新增尺码
     * @Date 22:14 2021/1/14
     * @Param [shopBean]
     * @return void
     **/
    @RequestMapping("addSize")
    @ResponseBody
    public void addSize(SizeBean sizeBean){
        shopService.addSize(sizeBean);
    }
    /**
     * @Author lh 
     * @Description  
     * @Date 19:00 2021/1/12
     * @Param [id]
     * @return void
     **/
    @RequestMapping("deleteById")
    @ResponseBody
    public void deleteById(Integer id){
        shopService.deleteById(id);
    }
    /**
     * @Author lh 
     * @Description  下架
     * @Date 19:01 2021/1/12
     * @Param [id]
     * @return void
     **/
    @RequestMapping("updateShopSatus")
    @ResponseBody
    public void updateShopSatus(Integer id){
        shopService.updateShopSatus(id);
    }
    
    /**
     * @Author lh 
     * @Description  上架
     * @Date 19:01 2021/1/12
     * @Param [id]
     * @return void
     **/
    @RequestMapping("updateUpShopSatus")
    @ResponseBody
    public void updateUpShopSatus(Integer id){
        shopService.updateUpShopSatus(id);
    }
    /**
     * @Author lh 
     * @Description  查询所有类型
     * @Date 19:15 2021/1/12
     * @Param []
     * @return java.util.List<com.jk.pojo.TypeBean>
     **/
    @RequestMapping("findType")
    @ResponseBody
    public List<TypeBean> findType(){
       return shopService.findType();
    }

    /**
     * @Author lh
     * @Description  查询品牌
     * @Date 20:08 2021/1/14
     * @Param []
     * @return java.util.List<com.jk.pojo.TypeBean>
     **/
    @RequestMapping("findBrand")
    @ResponseBody
    public List<BrandBean> findBrand(){
       return shopService.findBrand();
    }
    /**
     * @Author lh 
     * @Description  修改回显
     * @Date 19:53 2021/1/12
     * @Param [id]
     * @return com.jk.pojo.ShopBean
     **/
    @RequestMapping("findShopid")
    @ResponseBody
    public ShopBean findShopid(Integer id){
        ShopBean shop = shopService.findShopid(id);
        return shop;
    }
    /**
     * @Author lh 
     * @Description  修改回显
     * @Date 19:55 2021/1/12
     * @Param [id]
     * @return com.jk.pojo.TypeBean
     **/
    @RequestMapping("findTypeByid")
    @ResponseBody
    public TypeBean findTypeByid(Integer id){
        TypeBean type = shopService.findTypeByid(id);
        return type;
    }
    /**
     * @Author lh
     * @Description  新增类型
     * @Date 19:56 2021/1/12
     * @Param [id]
     * @return void
     **/
    @RequestMapping("addType")
    @ResponseBody
    public void addType(TypeBean typeBean){
         shopService.addType(typeBean);
    }
    /**
     * @Author lh
     * @Description  删除类型
     * @Date 20:05 2021/1/12
     * @Param [typeBean]
     * @return void
     **/
    @RequestMapping("deltype")
    @ResponseBody
    public void deltype(Integer id){
         shopService.deltype(id);
    }


    /**
     * @Author lh 
     * @Description  修改尺码
     * @Date 9:29 2021/1/15
     * @Param [id]
     * @return com.jk.pojo.SizeBean
     **/
    @RequestMapping("findShopSizeid")
    @ResponseBody
    public SizeBean findShopSizeid(Integer id){
        SizeBean sizeBean = shopService.findShopSizeid(id);
        return sizeBean;
    }
    /**
     * @Author lh
     * @Description  删除尺码
     * @Date 16:06 2021/1/15
     * @Param [id, count]
     * @return void
     **/
    @RequestMapping("delSizeshop")
    @ResponseBody
    public void delSizeshop(Integer id,Integer count,Integer sid){
        shopService.delSizeshop(id,count,sid);
    }



    /**
     * @Author lh
     * @Description  修改回显
     * @Date 18:14 2021/1/17
     * @Param [id]
     * @return com.jk.pojo.TypeBean
     **/
    @RequestMapping("findBrandByid")
    @ResponseBody
    public BrandBean findBrandByid(Integer id){
        BrandBean brand = shopService.findBrandByid(id);
        return brand;
    }

    /**
     * @Author lh
     * @Description  新增品牌
     * @Date 18:14 2021/1/17
     * @Param [typeBean]
     * @return void
     **/
    @RequestMapping("addBrand")
    @ResponseBody
    public void addBrand(BrandBean brandBean){
        shopService.addBrand(brandBean);
    }

    /**
     * @Author lh 
     * @Description  删除品牌
     * @Date 18:14 2021/1/17
     * @Param [id]
     * @return void
     **/
    @RequestMapping("delBrand")
    @ResponseBody
    public void delBrand(Integer id){
        shopService.delBrand(id);
    }
    
}
