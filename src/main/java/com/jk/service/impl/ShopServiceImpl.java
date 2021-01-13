package com.jk.service.impl;

import com.jk.dao.ShopDao;
import com.jk.pojo.ShopBean;
import com.jk.pojo.TypeBean;
import com.jk.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-12 17:07
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    public HashMap<String, Object> initShopTable(Integer page, Integer rows, ShopBean shopBean) {
        int total = shopDao.findUpTotal(shopBean);
        int start = (page-1)*rows;
        List<ShopBean> list = shopDao.initShopTable(start,rows,shopBean);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @Override
    public HashMap<String, Object> initdownShopTable(Integer page, Integer rows, ShopBean shopBean) {
        int total = shopDao.findDownTotal(shopBean);
        int start = (page-1)*rows;
        List<ShopBean> list = shopDao.initdownShopTable(start,rows,shopBean);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @Override
    public void deleteById(Integer id) {
        shopDao.deleteById(id);
    }

    @Override
    public void addShop(ShopBean shopBean) {
        if (shopBean.getId()==null) {
            shopDao.addShop(shopBean);
        }else {
            shopDao.updateShop(shopBean);
        }
    }

    @Override
    public void updateShopSatus(Integer id) {
        shopDao.updateShopSatus(id);
    }

    @Override
    public void updateUpShopSatus(Integer id) {
        shopDao.updateUpShopSatus(id);
    }

    @Override
    public List<TypeBean> findType() {
        return shopDao.findType();
    }

    @Override
    public ShopBean findShopid(Integer id) {
        return shopDao.findShopid(id);
    }

    @Override
    public TypeBean findTypeByid(Integer id) {
        return shopDao.findTypeByid(id);
    }

    @Override
    public void addType(TypeBean typeBean) {
        if (typeBean.getStypeid()==null){
            shopDao.addType(typeBean);
        }else {
            shopDao.updateType(typeBean);

        }
    }

    @Override
    public void deltype(Integer id) {
        shopDao.deltype(id);
    }
}
