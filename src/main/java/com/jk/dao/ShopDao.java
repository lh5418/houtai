package com.jk.dao;

import com.jk.pojo.BrandBean;
import com.jk.pojo.ShopBean;
import com.jk.pojo.SizeBean;
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

    List<BrandBean> findBrand();

    List<ShopBean> initSizeTable(@Param("id")Integer id, @Param("start")int start, @Param("rows")Integer rows, @Param("sizeBean") SizeBean sizeBean);

    int findSizeTotal(@Param("id")Integer id, @Param("sizeBean") SizeBean sizeBean);

    void addSize(SizeBean sizeBean);

    void updateShopCount(@Param("count") Integer xcount, @Param("id") Integer sid);

    SizeBean findShopSizeid(Integer id);

    void updateShopCountjian(@Param("count")Integer count, @Param("id")Integer sid);

    void delSizeshop(Integer id);

    void delteSize(Integer id);

    void updateShopCount2(@Param("ycount") Integer xcount, @Param("xcount") Integer xcount1, @Param("id") Integer sid);

    void updateSize(SizeBean sizeBean);

    BrandBean findBrandByid(Integer id);

    void addBrand(BrandBean brandBean);

    void updateBrand(BrandBean brandBean);

    void delBrand(Integer id);
}
