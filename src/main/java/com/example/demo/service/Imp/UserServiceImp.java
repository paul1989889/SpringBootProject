package com.example.demo.service.Imp;

import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.service.UserSerevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on  三月
 */

@Service
public class UserServiceImp implements UserSerevice {

    @Autowired
    private UserDao userDao;
    @Override
    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public User showUsers(String uid){
        return userDao.selectByPrimaryKey(uid);
    }
}
