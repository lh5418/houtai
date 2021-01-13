package com.jk.service;

import com.jk.pojo.OrderBean;

import java.util.HashMap;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-13 10:30
 */
public interface OrderService {
    HashMap<String, Object> initWaiOrderTable(Integer page, Integer rows, OrderBean orderBean);

    HashMap<String, Object> initFinalOrderTable(Integer page, Integer rows, OrderBean orderBean);

    void updateOrderStatus(Integer id);
}
