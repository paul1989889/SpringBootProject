package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.Imp.UserServiceImp;
import com.example.demo.service.UserSerevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on  十二月
 */
@RestController
public class LoginController {
    /**
     * 为什么这里不用UserService接口注入呢？总是报错存在两个bean
     */
   @Autowired
    private UserServiceImp userService;

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public User findUser(String name){
        User user =userService.findUserByName(name);

        return user;
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public User showUsers(String uid){
        User user =userService.showUsers(uid);
        return user;
    }
}