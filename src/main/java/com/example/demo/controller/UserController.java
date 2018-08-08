package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserSerevice;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by lenovo on  十二月
 */
@Controller
public class UserController {
    /**
     * 这里的注解运用了自动装配@Autowired和指定名称@Qualifier，效果相当于@Resource(name = "userServiceImpl")
     */
   @Autowired
   @Qualifier("userServiceImpl")
    private UserSerevice userService;

//redisTemplate在注入时，无法声明泛型
   @Autowired
   private RedisTemplate redisTemplate;

   private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    /**
     * 根据用户名显示用户信息
     * @param name
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ResponseBody
    public User findUserByName(String name){
        User user =userService.findUserByName(name);
        return user;
    }

    /**
     * 根据id显示用户的信息
     * @param uid
     * @return
     */
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    @ResponseBody
    public User showUsers(String uid){
        //从缓存中获取信息
        ValueOperations<String,User> valueOperations=redisTemplate.opsForValue();
        //判断缓存是否有记录,如果有记录就直接从缓存中获取信息
        boolean hasKey=redisTemplate.hasKey(uid);
        if(hasKey) {
            User user= valueOperations.get(uid);
            logger.debug("====================>从缓存中获取了用户id为"+uid+"的用户信息.");
            return  user;
        }
        User user =userService.showUsers(uid);
        //如果缓存中不存在信息，在查询过后，就将信息插入缓存中
        if(user!=null)  {
            valueOperations.set(uid,user);
            logger.debug("====================>将用户id为"+uid+"的用户信息插入缓存中.");
        }
        return user;
    }

    /**
     *  管理员才有权限添加
     * @return
     */
//    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String addUser(){
        return  "addUser";
    }
}