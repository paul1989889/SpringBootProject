package com.example.demo.config;


import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lenovo on  三月
 */
@Configuration
public class ShiroConfiguration {

    @Bean
     public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
         ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
         //设置安全管理器
         shiroFilterFactoryBean.setSecurityManager(securityManager);
         //默认跳转到登陆页面
         shiroFilterFactoryBean.setLoginUrl("/login");
         //登陆成功后的页面
         shiroFilterFactoryBean.setSuccessUrl("/index");
         shiroFilterFactoryBean.setUnauthorizedUrl("/403");

         //自定义过滤器
        Map<String,Filter> filterMap=new LinkedHashMap<>();
        shiroFilterFactoryBean.setFilters(filterMap);
        //权限控制map
        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<>();
//        // 配置不会被拦截的链接 顺序判断
//        filterChainDefinitionMap.put("/static/**", "anon");
//        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
//        filterChainDefinitionMap.put("/logout", "logout");
//        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
//        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
//        filterChainDefinitionMap.put("/**", "authc");

         shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
         return shiroFilterFactoryBean;
     }


     @Bean
    public SecurityManager securityManager(){
         DefaultSecurityManager securityManager=new DefaultSecurityManager();
         //设置realm
         securityManager.setRealm( new UserRealm());
         securityManager.setRememberMeManager(rememberMeManager());
         return securityManager;
     }

    /**
     * 记住我管理器
     * @return
     */
     @Bean
    public CookieRememberMeManager rememberMeManager() {
         CookieRememberMeManager cookieRememberMeManager=new CookieRememberMeManager();
         cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥  默认AES算法
//         cookieRememberMeManager.setCipherKey();
         return  cookieRememberMeManager;
    }

    /**
     * cookie对象
     * @return
     */
    @Bean
    public Cookie rememberMeCookie() {
        SimpleCookie simpleCookie=new SimpleCookie("rememberMe");
        //记住我cookie生效时间，单位秒
        simpleCookie.setMaxAge(3600);
        return simpleCookie;
    }

}
