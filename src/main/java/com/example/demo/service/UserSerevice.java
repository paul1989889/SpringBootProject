package com.example.demo.service;

import com.example.demo.pojo.User;

/**
 * Created by lenovo on  三月
 */
public interface UserSerevice {
    public User findUserByName(String userName);
    public User showUsers(String uid);
}
