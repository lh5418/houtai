package com.jk.controller;

import com.jk.pojo.OrderBean;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-13 10:30
 */
@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * @Author lh 
     * @Description  未发货订单
     * @Date 10:32 2021/1/13
     * @Param [page, rows, shopBean]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("initWaiOrderTable")
    @ResponseBody
    public HashMap<String, Object> initWaiOrderTable(Integer page, Integer rows, OrderBean orderBean){
        return orderService.initWaiOrderTable(page,rows,orderBean);
    }
    
    /**
     * @Author lh 
     * @Description  已完成和待收货订单
     * @Date 10:57 2021/1/13
     * @Param [page, rows, orderBean]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("initFinalOrderTable")
    @ResponseBody
    public HashMap<String, Object> initFinalOrderTable(Integer page, Integer rows, OrderBean orderBean){
        return orderService.initFinalOrderTable(page,rows,orderBean);
    }
    /**
     * @Author lh
     * @Description  发货
     * @Date 11:14 2021/1/13
     * @Param [id]
     * @return void
     **/
    @RequestMapping("updateOrderStatus")
    @ResponseBody
    public void updateOrderStatus(Integer id){
        orderService.updateOrderStatus(id);
    }

}
