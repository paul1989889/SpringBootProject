package com.example.demo.dao;

import com.example.demo.pojo.SysUserRole;
import com.example.demo.pojo.User;

import java.util.List;
import java.util.Set;

public interface SysUserRoleDao {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

    Set<SysUserRole> findRoleIdByUid(int uid);

//    级联查询.通过RoleId查找对应的User信息
    SysUserRole findUserByRoleId(int roleId);
}