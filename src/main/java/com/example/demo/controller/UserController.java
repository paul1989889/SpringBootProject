package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.Imp.UserServiceImp;
import com.example.demo.service.UserSerevice;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lenovo on  十二月
 */
@Controller
public class UserController {
    /**
     * 这里的注解运用了自动装配@Autowired和指定名称@Qualifier，效果相当于@Resource(name = "userServiceImpl")
     */
   @Autowired
   @Qualifier("userServiceImp")
    private UserSerevice userService;


    /**
     * 根据用户名显示用户信息
     * @param name
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ResponseBody
    public User findUserByName(String name){
        User user =userService.findUserByName(name);
        return user;
    }

    /**
     * 根据id显示用户的信息
     * @param uid
     * @return
     */
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    @ResponseBody
    public User showUsers(String uid){
        User user =userService.showUsers(uid);
        return user;
    }

    /**
     *  管理员才有权限添加
     * @return
     */
//    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String addUser(){
        return  "addUser";
    }
}