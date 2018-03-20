package com.example.demo.dao;

import com.example.demo.pojo.SysUserRole;

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
}