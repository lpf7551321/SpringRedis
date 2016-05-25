package com.netease.controller;

import com.netease.meta.bean.User;
import com.netease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by hz-lpf on 16-5-19.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private int pageStatus;

    @RequestMapping(value = "/form")
    public String form(ModelMap modelmap) {
        pageStatus = 0;
        modelmap.addAttribute("pageStatus", pageStatus);
        return "form";
    }

    @RequestMapping("/success")
    public String form(ModelMap modelMap, @RequestParam String name, @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setId(0);
        pageStatus = 1;
        userService.insert(user);
        modelMap.addAttribute("pageStatus", pageStatus);
        modelMap.addAttribute("user", user);
        System.out.println("*******");
        return "form";
    }

    @RequestMapping("/search")
    public String search(ModelMap modelMap) {
        pageStatus = 2;
        modelMap.addAttribute("pageStatus", pageStatus);
        return "form";
    }

    @RequestMapping("/searchSuccess")
    public String searchSuccess(ModelMap modelMap, @RequestParam int start, @RequestParam int end) {
        List<User> users = userService.batchFindById(start, end);
        modelMap.addAttribute("users",users);
        pageStatus = 1;
        return "form";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
