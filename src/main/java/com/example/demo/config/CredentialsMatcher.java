package com.example.demo.config;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * Created by lenovo on  三月
 *
 * CredentialsMatcher是一个接口，功能就是用来匹配用户登录使用的令牌和数据库中保存的用户信息是否匹配。
 * 这个类在ShiroConfiguration中注入，并设置为注入的Realm类的属性。
 * 也可以不写这个类，直接在ShiroConfiguration用HashedCredentialsMatcher注入。
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {
    /**
     * 进行密码的比对,验证密码是否正确
     * @param authenticationToken
     * @param info
     * @return
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo info){
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        //获得用户输入的密码，可以用加盐(salt)的方式去检验
        String inPassword=new String(token.getPassword());
        //获得数据库中的密码
        String daPassword=(String) info.getCredentials();
        //进行密码的比对
        return  this.equals(inPassword,daPassword);
    }
}
