package com.jk.service.impl;

import com.jk.dao.OrderDao;
import com.jk.pojo.OrderBean;
import com.jk.pojo.ShopBean;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-13 10:30
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public HashMap<String, Object> initWaiOrderTable(Integer page, Integer rows, OrderBean orderBean) {
        int total = orderDao.findWaitTotal(orderBean);
        int start = (page-1)*rows;
        List<ShopBean> list = orderDao.initWaiOrderTable(start,rows,orderBean);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @Override
    public HashMap<String, Object> initFinalOrderTable(Integer page, Integer rows, OrderBean orderBean) {
        int total = orderDao.findFinalTotal(orderBean);
        int start = (page-1)*rows;
        List<ShopBean> list = orderDao.initFinalOrderTable(start,rows,orderBean);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @Override
    public void updateOrderStatus(Integer id) {
        orderDao.updateOrderStatus(id);
    }
}
