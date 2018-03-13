package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/9/30.
 */
@RestController
public class TestController {
    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    public String test() {
        return "test";
    }
}
