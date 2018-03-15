package com.example.demo.dao;

import com.example.demo.pojo.SysPermission;

public interface SysPermissionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission findPermissionById(int id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}