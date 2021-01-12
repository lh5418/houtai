package com.jk.controller;

import com.jk.pojo.RoleBean;
import com.jk.pojo.TreeBean;
import com.jk.pojo.UserBean;
import com.jk.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-12 10:25
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Bean(value = "userService")
    public UserService getUserService(){
        return userService;
    }



    /**
     * @Author lh
     * @Description  登录
     * @Date 10:33 2021/1/12
     * @Param [userBean]
     * @return java.lang.String
     **/
    @RequestMapping("login")
    @ResponseBody
    public String login(UserBean userBean){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userBean.getName(), userBean.getPwd());
        try {
            subject.login(token);
            return "登录成功！！";
        }catch (UnknownAccountException e){
            return "账号不存在!!";
        }catch (IncorrectCredentialsException e){
            return "密码错误！！";
        }catch (AuthenticationException e){
            return "用户认证失败！！";
        }
    }

   /**
    * @Author lh 
    * @Description  
    * @Date 11:17 2021/1/12
    * @Param []
    * @return java.util.List<com.jk.pojo.TreeBean>
    **/
    @RequestMapping("findTree")
    @ResponseBody
    public List<TreeBean> findTree() {
        Subject subject = SecurityUtils.getSubject();
        UserBean user = (UserBean) subject.getPrincipal();

        return userService.findTree(user.getId());
    }

    /**
     * @Author lh 
     * @Description  用户列表
     * @Date 11:24 2021/1/12
     * @Param []
     * @return java.util.List<com.jk.pojo.UserBean>
     **/

    @RequestMapping("initTable")
    @ResponseBody
    public List<UserBean> initTable() {
        List<UserBean> userBeans = userService.initTable();
        return userBeans;
    }

    /**
     * @Author lh 
     * @Description  所有角色
     * @Date 11:25 2021/1/12
     * @Param []
     * @return java.util.List<RoleBean>
     **/
    @RequestMapping("findRole")
    @ResponseBody
    public List<RoleBean> findRole() {
        List<RoleBean> roleBeans = userService.findRole();
        return roleBeans;
    }

    /**
     * @Author lh
     * @Description  新增修改用户
     * @Date 11:27 2021/1/12
     * @Param [userBean]
     * @return void
     **/
    @RequestMapping("addUser")
    @ResponseBody
    public void addUser(UserBean userBean) {
        userService.addUser(userBean);
    }
    /**
     * @Author lh 
     * @Description  删除
     * @Date 14:20 2021/1/12
     * @Param [id]
     * @return void
     **/
    @RequestMapping("deleteById")
    @ResponseBody
    public void deleteById(Integer id) {
        userService.deleteById(id);
    }

    /**
     * @Author lh 
     * @Description  修改回显
     * @Date 11:27 2021/1/12
     * @Param [userId]
     * @return com.jk.pojo.UserBean
     **/
    @RequestMapping("queryUserById")
    @ResponseBody
    public UserBean queryUserById(Integer userId) {
        return userService.queryUserById(userId);
    }
    /**
     * @Author lh 
     * @Description  权限树查询
     * @Date 11:39 2021/1/12
     * @Param [roleid]
     * @return java.util.List<com.jk.pojo.TreeBean>
     **/
    @RequestMapping("queryPower")
    @ResponseBody
    public List<TreeBean> queryPower(Integer roleid) {
        List<TreeBean> treeBeans = userService.queryPower(roleid);
        return treeBeans;
    }

    /**
     * @Author lh 
     * @Description  修改权限名称
     * @Date 11:39 2021/1/12
     * @Param [tree]
     * @return void
     **/
    @RequestMapping("updatePower")
    @ResponseBody
    public void updatePower(TreeBean tree) {
        userService.updatePower(tree);
    }

    /**
     * @Author lh 
     * @Description  新增权限
     * @Date 11:40 2021/1/12
     * @Param [tree]
     * @return void
     **/
    @RequestMapping("savePower")
    @ResponseBody
    public void savePower(TreeBean tree) {
        userService.savePower(tree);
    }

    /**
     * @Author lh
     * @Description  删除权限
     * @Date 11:40 2021/1/12
     * @Param [id]
     * @return void
     **/
    @RequestMapping("deletePower")
    @ResponseBody
    public void deletePower(Integer id) {
        userService.deletePower(id);
    }

    /**
     * @Author lh 
     * @Description  赋权限
     * @Date 11:40 2021/1/12
     * @Param [roleid, powerids]
     * @return void
     **/
    @RequestMapping("saveRolePower")
    @ResponseBody
    public void saveRolePower(Integer roleid, String[] powerids) {
        userService.saveRolePower(roleid,powerids);
    }


  /**
   * @Author lh
   * @Description  修改密码
   * @Date 14:27 2021/1/12
   * @Param [userBean, session]
   * @return java.lang.String
   **/
    @RequestMapping("updateuser")
    @ResponseBody
    public String updateuser(UserBean userBean){
        Subject subject = SecurityUtils.getSubject();
        UserBean user = (UserBean) subject.getPrincipal();
        userBean.setId(user.getId());
        return  userService.updateuser(userBean);
    }

}
