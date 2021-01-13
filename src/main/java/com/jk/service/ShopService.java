package com.jk.service;

import com.jk.pojo.ShopBean;
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

    HashMap<String, Object> initdownShopTable(Integer page, Integer rows, ShopBean shopBean);

    void deleteById(Integer id);

    void addShop(ShopBean shopBean);

    void updateShopSatus(Integer id);

    void updateUpShopSatus(Integer id);

    List<TypeBean> findType();

    ShopBean findShopid(Integer id);

    TypeBean findTypeByid(Integer id);

    void addType(TypeBean typeBean);

    void deltype(Integer id);
}
