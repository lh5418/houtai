package com.jk.dao;

import com.jk.pojo.OrderBean;
import com.jk.pojo.ShopBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-13 10:31
 */
@Repository
public interface OrderDao {
    int findWaitTotal(@Param("orderBean") OrderBean orderBean);

    List<ShopBean> initWaiOrderTable(@Param("start")int start, @Param("rows")Integer rows, @Param("orderBean")OrderBean orderBean);

    List<ShopBean> initFinalOrderTable(@Param("start")int start, @Param("rows")Integer rows, @Param("orderBean")OrderBean orderBean);

    int findFinalTotal(@Param("orderBean") OrderBean orderBean);

    void updateOrderStatus(Integer id);
}
