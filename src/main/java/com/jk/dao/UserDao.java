package com.jk.dao;

import com.jk.pojo.RoleBean;
import com.jk.pojo.TreeBean;
import com.jk.pojo.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-12 10:28
 */
@Repository
@Mapper
public interface UserDao {

     UserBean findUserByName(String username) ;

     List<TreeBean> findTree(@Param("pid") int pid, @Param("userid") Integer id);

    List<String> findPowerByUserid(Integer id);

    List<String> findRolePower(Integer id);

    List<UserBean> initTable();

    List<RoleBean> findRole();

    void updateUser(UserBean userBean);

    void delUserRoleByUserid(Integer id);

    void addUser(UserBean userBean);

    void addUserRole(@Param("arr") String[] roldidarr, @Param("userid") Integer id);

    UserBean queryUserById(Integer userId);

    List<TreeBean> findPowerByRoleid(Integer roleid);

    List<TreeBean> queryTreeByPid(int pid);

    void updatePower(TreeBean tree);

    void savePower(TreeBean tree);

    void deletePowerAll(@Param("list") List<Integer> idlist);

    List<Integer> findPowerByPid(Integer id);

    void delrpRoleid(Integer roleid);

    void saveRolePower(@Param("roleid") Integer roleid, @Param("powerids") String[] powerids);

    void delUser(Integer id);

    void updateuserPwd(UserBean userBean);

    UserBean findUserById(Integer id);
}
