package com.example.demo.realm;

import com.example.demo.pojo.SysPermission;
import com.example.demo.pojo.SysUserRole;
import com.example.demo.pojo.User;
import com.example.demo.service.UserSerevice;
import com.example.demo.utils.State;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.apache.coyote.http11.Constants.a;

/**
 * Created by lenovo on  三月
 */
public class UserRealm extends AuthorizingRealm {
    @Resource(name = "userServiceImp")
    private UserSerevice userSerevice;

    /**
     * 提供用户信息，返回权限信息
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        String userName=(String) principals.getPrimaryPrincipal();
        String userId=userSerevice.findUserIdByName(userName);
        Set<SysUserRole> roleIdSet=userSerevice.findRoleIdByUid( Integer.parseInt(userId) );
        Set<String> roleSet=new HashSet<>();
        Set<Integer>  pemissionIdSet=new HashSet<>();
        Set<String>  pemissionSet=new HashSet<>();
        for(SysUserRole roleInfo : roleIdSet) {
              int roleId=roleInfo.getRoleId();
               roleSet.add( userSerevice.findRoleByRoleId( roleId  ) );
               //将拥有角色的所有权限放进Set里面，也就是求Set集合的并集
              pemissionIdSet.addAll( userSerevice.findPermissionIdByRoleId(  roleId ));
        }
        for(int permissionId : pemissionIdSet) {
            pemissionSet.add(  userSerevice.findPermissionById(permissionId).getName());
        }
         // 将角色名称提供给授权info
        authorizationInfo.setRoles( roleSet );
        // 将权限名称提供给info
        authorizationInfo.setStringPermissions(pemissionSet);

        return authorizationInfo;
    }

    /**
     * 提供帐户信息，返回认证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName=(String)authenticationToken.getPrincipal();
        User user=userSerevice.findUserByName(userName);
        if(user==null) {
            //用户不存在就抛出异常
            throw new UnknownAccountException();
        }
        if( State.LOCKED.equals( user.getState() )  ) {
           //用户被锁定就抛异常
           throw new  LockedAccountException();
        }
        //此处的密码盐需要修复
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), null,getName());

        return authenticationInfo;
    }
}
