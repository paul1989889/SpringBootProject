package com.example.demo.service;

import com.example.demo.pojo.SysPermission;
import com.example.demo.pojo.User;

import java.util.List;
import java.util.Set;

/**
 * Created by lenovo on  三月
 */
public interface UserSerevice {
    public User findUserByName(String userName);
    public User showUsers(String uid);
    public String findUserIdByName(String userName);
    public Set findRoleIdByUid(int uid);
    public int findPermissionIdByRoleId(int roleId);
    public  String findRoleByRoleId(int roleId);
    public SysPermission findPermissionById(int id);
}
