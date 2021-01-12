package com.jk.service;

import com.jk.pojo.RoleBean;
import com.jk.pojo.TreeBean;
import com.jk.pojo.UserBean;

import java.util.List;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-12 10:26
 */
public interface UserService {
    UserBean findUserByName(String username);

    List<TreeBean> findTree(Integer id);

    List<String> findPowerByUserid(Integer id);

    List<String> findRolePower(Integer id);

    List<UserBean> initTable();

    List<RoleBean> findRole();

    void addUser(UserBean userBean);

    UserBean queryUserById(Integer userId);

    List<TreeBean> queryPower(Integer roleid);

    void updatePower(TreeBean tree);

    void savePower(TreeBean tree);

    void deletePower(Integer id);

    void saveRolePower(Integer roleid, String[] powerids);

    void deleteById(Integer id);

    String updateuser(UserBean userBean);
}
