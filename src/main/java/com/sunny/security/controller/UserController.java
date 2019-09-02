package com.sunny.security.controller;


import com.sunny.security.entity.Qyxx;
import com.sunny.security.permission.bean.UserInfo;
import com.sunny.security.service.QyxxService;
import com.sunny.security.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: 孙宇豪
 * @Date: 2019/5/22 15:23
 * @Description: TODO
 * @Version 1.0
 */
@Controller
public class UserController {

    @Autowired
    private QyxxService qyxxService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "findAllqy")
    public String findAllqy(HttpServletRequest request) {

        List<Qyxx> all = qyxxService.findAll();

        request.setAttribute("lists", all);

        return "listqy";
    }

    /**
     * 跳转用户管理页面
     * */
    @GetMapping("findAllUser")
    public String findAllUser(Model model){
        List<UserInfo> allUser = userInfoService.findAllUser();
        model.addAttribute("users",allUser);
        return "user";
    }


    /**
     * 跳转用户添加页面
     * */
    @GetMapping("addUserPage")
    public String addUserPage(){
        return "addUser";
    }

//    /**
//     * 添加用户方法
//     * */
//    @PostMapping("addUser")
//    public String
}
