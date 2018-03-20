package com.example.demo.controller;

import com.example.demo.service.UserSerevice;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lenovo on  三月
 */
//@RestController
@Controller
public class LoginController {

    @Resource(name="userServiceImp")
    private UserSerevice userSerevice;

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index() {
        return "/login";
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(@RequestParam("userName")String userName, @RequestParam("password") String password, Model model){
        System.out.println("---->进入登陆方法内：");
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userName,password);
        //这里有bug，取到的subject总是空的。。
        Subject subject=SecurityUtils.getSubject();

        try {
              subject.login(usernamePasswordToken);
        }catch (IncorrectCredentialsException ice){
             model.addAttribute("error","password error");
             return "error";
        }catch (UnknownAccountException uae) {
            model.addAttribute("error","userName error");
            return "error";
        }catch (ExcessiveAttemptsException eae) {
            model.addAttribute("error","time error");
            return "error";
        }
        return "login";
    }

}
