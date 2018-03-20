package com.example.demo.dao;

import com.example.demo.pojo.SysRolePermission;

import java.util.Set;

public interface SysRolePermissionDao {
    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    Set<Integer> findPermissionIdByRoleId(int roleId);
}