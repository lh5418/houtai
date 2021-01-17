package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-12 11:17
 */
@Controller
@RequestMapping("page")
public class PageController {

    /**
     * @Author lh
     * @Description  登录页面
     * @Date 10:32 2021/1/12
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login2";
    }

    /**
     * @Author lh
     * @Description  登录成功页面
     * @Date 10:32 2021/1/12
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("tomain")
    public String tomain(){
        return "main";
    }

    /**
     * @Author lh
     * @Description  用户页面
     * @Date 11:19 2021/1/12
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("usershow")
    public String usershow(){
        return "usershow";
    }
    
    /**
     * @Author lh 
     * @Description  权限页面
     * @Date 11:38 2021/1/12
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("userlist")
    public String userlist(){
        return "userlist";
    }

    /**
     * @Author lh 
     * @Description  修改密码页面
     * @Date 14:49 2021/1/12
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("myshow")
    public String myshow(){
        return "myshow";
    }

    /**
     * @Author lh
     * @Description  上架商品页面
     * @Date 16:39 2021/1/12
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("upshop")
    public String upshop(){
        return "upshop";
    }
    /**
     * @Author lh 
     * @Description  下架商品
     * @Date 17:33 2021/1/12
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("downshop")
    public String downshop(){
        return "downshop";
    }
    
    /**
     * @Author lh 
     * @Description  类型
     * @Date 19:48 2021/1/12
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("type")
    public String type(){
        return "addtype";
    }
    
    /**
     * @Author lh 
     * @Description  代发货页面
     * @Date 9:59 2021/1/13
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("waitOrder")
    public String waitOrder(){
        return "waitOrder";
    }
    
    /**
     * @Author lh 
     * @Description  已完成订单
     * @Date 10:20 2021/1/13
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("finalOrder")
    public String finalOrder(){
        return "finalOrder";
    }
    
    /**
     * @Author lh 
     * @Description  品牌页面
     * @Date 18:13 2021/1/17
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("brand")
    public String brand(){
        return "brand";
    }
}
