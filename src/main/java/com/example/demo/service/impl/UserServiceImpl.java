package com.example.demo.service.impl;

import com.example.demo.controller.UserController;
import com.example.demo.dao.*;
import com.example.demo.pojo.SysPermission;
import com.example.demo.pojo.SysUserRole;
import com.example.demo.pojo.User;
import com.example.demo.service.UserSerevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by lenovo on  三月
 */

@Service
@CacheConfig
public class UserServiceImpl implements UserSerevice {
    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private UserDao userDao;
    @Autowired
    private SysUserRoleDao userRoleDao;
    @Autowired
    private SysRolePermissionDao rolePermissionDao;
    @Autowired
    private SysRoleDao roleDao;
    @Autowired
    private SysPermissionDao permissionDao;

    //redisTemplate在注入时，无需声明泛型
    @Autowired
    private RedisTemplate redisTemplate;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User findUserByName(String name) {
        return userDao.findUserByUserName(name);
    }

    @Override
//    @Cacheable( cacheNames = "users" ,condition = "#uid!=null",key = "#uid")
    public User showUsers(String uid){
//        Cache cache=cacheManager.getCache("users");
//        User user=cache.get(uid,User.class);
//        if(user!=null) {
//            System.out.println("----------------->读取到缓存中的数据："+user.toString());
//        }else {
//            cache.put(uid,userDao.selectByPrimaryKey(uid));
//            System.out.println("----------------->缓存中不存在数据");
//        }

        //从缓存中获取信息
        ValueOperations<String,User> valueOperations=redisTemplate.opsForValue();
        //判断缓存是否有记录,如果有记录就直接从缓存中获取信息
        boolean hasKey=redisTemplate.hasKey(uid);
        if(hasKey) {
            User user= valueOperations.get(uid);
            logger.debug("====================>从缓存中获取了用户id为"+uid+"的用户信息.");
            return  user;
        }
        User user =userDao.selectByPrimaryKey(uid);
        //如果缓存中不存在信息，在查询过后，就将信息插入缓存中
        if(user!=null)  {
            valueOperations.set(uid,user);
            logger.debug("====================>将用户id为"+uid+"的用户信息插入缓存中.");
        }
        return user;
    }

    @Override
    public String findUserIdByName(String userName) {
        return userDao.findIdByUserName(userName);
    }

    @Override
    public Set<SysUserRole> findRoleIdByUid(int uid) {
        return userRoleDao.findRoleIdByUid(uid);
    }

    @Override
    public Set<Integer> findPermissionIdByRoleId(int roleId) {
        return rolePermissionDao.findPermissionIdByRoleId(roleId);
    }

    @Override
    public String findRoleByRoleId(int roleId) {
        return roleDao.findRoleByRoleId(roleId);
    }

    @Override
    public SysPermission findPermissionById(int id) {
        return permissionDao.findPermissionById(id);
    }

    @Override
    public User findRoleIdByUserName(String userName) {
        return userDao.findRoleIdByUserName(userName);
    }


}
