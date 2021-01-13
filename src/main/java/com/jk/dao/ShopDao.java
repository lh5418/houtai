package com.jk.dao;

import com.jk.pojo.ShopBean;
import com.jk.pojo.TypeBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-12 17:07
 */
@Repository
public interface ShopDao {
    int findUpTotal(@Param("shopBean") ShopBean shopBean);

    List<ShopBean> initShopTable(@Param("start")int start, @Param("rows")Integer rows, @Param("shopBean")ShopBean shopBean);

    int findDownTotal(@Param("shopBean")ShopBean shopBean);

    List<ShopBean> initdownShopTable(@Param("start")int start, @Param("rows")Integer rows, @Param("shopBean")ShopBean shopBean);

    void deleteById(Integer id);

    void addShop(ShopBean shopBean);

    void updateShopSatus(Integer id);

    void updateUpShopSatus(Integer id);

    List<TypeBean> findType();

    ShopBean findShopid(Integer id);

    void updateShop(ShopBean shopBean);

    TypeBean findTypeByid(Integer id);

    void addType(TypeBean typeBean);

    void updateType(TypeBean typeBean);

    void deltype(Integer id);
}
