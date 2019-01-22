package com.example.yxw.controller;

import com.example.yxw.domain.User;
import com.example.yxw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("show")
    public User getIndex(String username) {
        return userService.selectUserByName(username);
    }

    @RequestMapping("index")
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("layout1.html");
        return modelAndView;
    }
}