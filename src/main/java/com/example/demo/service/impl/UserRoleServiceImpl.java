package com.example.demo.service.impl;

import com.example.demo.dao.SysUserRoleDao;
import com.example.demo.pojo.SysUserRole;
import com.example.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on  七月
 */
@Service
@CacheConfig
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private SysUserRoleDao userRoleDao;

    @Override
    public SysUserRole findUserByRoleId(int roleId) {
        return userRoleDao.findUserByRoleId(roleId);
    }
}
