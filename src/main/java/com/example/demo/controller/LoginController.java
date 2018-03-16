package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.Imp.UserServiceImp;
import com.example.demo.service.UserSerevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lenovo on  十二月
 */
@RestController
public class LoginController {
    /**
     * 这里的注解运用了自动装配@Autowired和指定名称@Qualifier，效果相当于@Resource(name = "userServiceImpl")
     */
   @Autowired
   @Qualifier("userServiceImp")
    private UserSerevice userService;

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public User findUserByName(String name){
        User user =userService.findUserByName(name);
        return user;
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public User showUsers(String uid){
        User user =userService.showUsers(uid);
        return user;
    }
}