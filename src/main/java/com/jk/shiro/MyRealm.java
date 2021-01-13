package com.jk.shiro;

import com.jk.pojo.UserBean;
import com.jk.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.List;

/**
 * @program: shiro_lh
 * @description:
 * @author: 刘海
 * @create: 2020-12-29 15:23
 */
public class MyRealm  extends AuthorizingRealm {

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserBean user = (UserBean) principalCollection.getPrimaryPrincipal();
        UserService userService = SpringBeanFactoryUtils.getBean("userService", UserService.class);
       List<String> list =userService.findPowerByUserid(user.getId());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
         info.addStringPermissions(list);

        List<String> list2 =userService.findRolePower(user.getId());
        info.addRoles(list2);
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username= (String) authenticationToken.getPrincipal();
        UserService userService = SpringBeanFactoryUtils.getBean("userService", UserService.class);
        UserBean user =userService.findUserByName(username);
        if (user==null){
            return null;
        }
        SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(user, user.getPwd(), this.getName());
        return sai;
    }
}
