package com.jk.service;

import com.jk.pojo.BrandBean;
import com.jk.pojo.ShopBean;
import com.jk.pojo.SizeBean;
import com.jk.pojo.TypeBean;

import java.util.HashMap;
import java.util.List;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-12 17:06
 */
public interface ShopService {
    HashMap<String, Object> initShopTable(Integer page, Integer rows, ShopBean shopBean);

    void deleteById(Integer id);

    void addShop(ShopBean shopBean);

    void updateShopSatus(Integer id);

    void updateUpShopSatus(Integer id);

    List<TypeBean> findType();

    ShopBean findShopid(Integer id);

    TypeBean findTypeByid(Integer id);

    void addType(TypeBean typeBean);

    void deltype(Integer id);

    List<BrandBean> findBrand();

    HashMap<String, Object> initSizeTable(Integer id,Integer page, Integer rows, SizeBean sizeBean);

    void addSize(SizeBean sizeBean);

    SizeBean findShopSizeid(Integer id);
}
