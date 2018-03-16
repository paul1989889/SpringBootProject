package com.example.demo.dao;

import com.example.demo.pojo.User;

public interface UserDao {
    int deleteByPrimaryKey(String uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    String findUserIdByName(String userName);

    User findUserByUserName(String userName);
}