package com.example.demo.service.Imp;

import com.example.demo.dao.*;
import com.example.demo.pojo.SysPermission;
import com.example.demo.pojo.SysUserRole;
import com.example.demo.pojo.User;
import com.example.demo.service.UserSerevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by lenovo on  三月
 */

@Service
public class UserServiceImp implements UserSerevice {

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

    @Override
    public User findUserByName(String name) {
        return userDao.findUserByUserName(name);
    }

    @Override
    public User showUsers(String uid){
        return userDao.selectByPrimaryKey(uid);
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
}
