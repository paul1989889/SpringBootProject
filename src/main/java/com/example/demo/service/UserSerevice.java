package com.example.demo.service;

import com.example.demo.pojo.SysPermission;
import com.example.demo.pojo.SysUserRole;
import com.example.demo.pojo.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Set;

/**
 * Created by lenovo on  三月
 */

public interface UserSerevice {
      User findUserByName(String userName);
      User showUsers(String uid);
      String findUserIdByName(String userName);
      Set<SysUserRole> findRoleIdByUid(int uid);
      Set<Integer> findPermissionIdByRoleId(int roleId);
      String findRoleByRoleId(int roleId);
      SysPermission findPermissionById(int id);
      User findRoleIdByUserName(String userName);


}
