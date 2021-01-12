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
}
