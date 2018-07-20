package com.example.demo.service;

import com.example.demo.pojo.SysUserRole;

import java.util.Set;

/**
 * Created by lenovo on  七月
 */

public interface UserRoleService {


    //    级联查询.通过RoleId查找对应的User信息
    SysUserRole findUserByRoleId(int roleId);
}
