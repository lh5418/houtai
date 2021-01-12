package com.jk.service.impl;

import com.jk.dao.UserDao;
import com.jk.pojo.RoleBean;
import com.jk.pojo.TreeBean;
import com.jk.pojo.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-12 10:28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserBean findUserByName(String username) {
        return userDao.findUserByName(username);
    }

    @Override
    public List<TreeBean> findTree(Integer id) {
        int pid = 0;
        List<TreeBean> list = findNode(pid,id);
        return list;
    }

    @Override
    public List<String> findPowerByUserid(Integer id) {
        return userDao.findPowerByUserid(id);
    }

    @Override
    public List<String> findRolePower(Integer id) {
        return userDao.findRolePower(id);
    }

    @Override
    public List<UserBean> initTable() {
        return userDao.initTable();
    }

    @Override
    public List<RoleBean> findRole() {
        return userDao.findRole();
    }

    @Override
    public void addUser(UserBean userBean) {
        Integer id = userBean.getId();
        if (id!=null){
            userDao.updateUser(userBean);
            userDao.delUserRoleByUserid(id);
        }else {
            userDao.addUser(userBean);
        }
        String roleid = userBean.getRoleid();
        String[] roldidarr = roleid.split(",");
        userDao.addUserRole(roldidarr,userBean.getId());
    }

    @Override
    public UserBean queryUserById(Integer userId) {
        return userDao.queryUserById(userId);
    }

    @Override
    public List<TreeBean> queryPower(Integer roleid) {
        List<TreeBean> rolepowerlist = userDao.findPowerByRoleid(roleid);
        int pid = 0;
        List<TreeBean> list = queryPowerNodes(pid,rolepowerlist);

        //根节点对象
        TreeBean tree = new TreeBean();
        tree.setId(0);
        tree.setText("根节点");
        tree.setChildren(list);

        List<TreeBean> list2 = new ArrayList<TreeBean>();
        list2.add(tree);
        return list2;
    }

    private List<TreeBean> queryPowerNodes(int pid, List<TreeBean> rolepowerlist) {
        List<TreeBean> list = userDao.queryTreeByPid(pid);

        for (TreeBean treeBean : list) {
            Integer id = treeBean.getId();
            //查询对应的子节点
            List<TreeBean> nodes = queryPowerNodes(id,rolepowerlist);//递归：自己调自己
            treeBean.setChildren(nodes);

            //处理：给当前角色所拥有的权限  checked:true
            for (TreeBean power : rolepowerlist) {
                if(nodes.size()<=0&&power.getId()==id){//没有子节点
                    treeBean.setChecked(true);
                }
            }

        }
        return list;
    }

    @Override
    public void updatePower(TreeBean tree) {
        userDao.updatePower(tree);
    }

    @Override
    public void savePower(TreeBean tree) {
        userDao.savePower(tree);
    }

    @Override
    public void deletePower(Integer id) {
    //递归查询所有的子节点的id
        List<Integer> idlist = new ArrayList<Integer>();
        idlist.add(id);

        findNodeId(id,idlist);


        //批量删除
        userDao.deletePowerAll(idlist);
    }
    private void findNodeId(Integer id, List<Integer> idlist) {
        List<Integer> list = userDao.findPowerByPid(id);
        for (Integer id2 : list) {
            findNodeId(id2,idlist);
        }
        idlist.addAll(list);
    }

    @Override
    public void saveRolePower(Integer roleid, String[] powerids) {
        //删除
        userDao.delrpRoleid(roleid);
        //批量新增
        userDao.saveRolePower(roleid,powerids);
    }

    @Override
    public void deleteById(Integer id) {
        userDao.delUser(id);
        userDao.delUserRoleByUserid(id);
    }

    @Override
    public String updateuser(UserBean userBean) {
        UserBean user=userDao.findUserById(userBean.getId());
        if (!userBean.getName().equals(user.getPwd())){
            return "原密码错误！！";
        }else {
            userDao.updateuserPwd(userBean);
            return "修改密码成功";
        }

    }

    private List<TreeBean> findNode(int pid, Integer id) {
        List<TreeBean> list = userDao.findTree(pid,id);
        for (TreeBean tree : list) {
            Integer id2 = tree.getId();
            List<TreeBean> list2 = findNode(id2,id);
            tree.setChildren(list2);
        }
        return list;
    }

}
