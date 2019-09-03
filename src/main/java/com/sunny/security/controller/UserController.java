package com.sunny.security.controller;


import com.sunny.security.entity.Qyxx;
import com.sunny.security.permission.bean.UserInfo;
import com.sunny.security.service.QyxxService;
import com.sunny.security.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    /**
     * 添加用户方法
     * */
    @PostMapping("addUser")
    public String addUser(@ModelAttribute("user") UserInfo userInfo){
        String password = userInfo.getPassword();
        userInfo.setPassword(passwordEncoder.encode(password));
        userInfoService.save(userInfo);
        return "redirect:/findAllUser";
    }

    /**
     * 查询用户详情
     * */
    @GetMapping("/findUserByUid")
    public String findUserByUid(Integer id, ModelMap modelMap){
        UserInfo userById = userInfoService.findUserById(id);
        modelMap.addAttribute("userDetail",userById);
        return "userDetail";
    }

    /**
     * 更新用户信息页面
     * */
    @GetMapping("/updateUserPage")
    public String updateUserPage(Integer id,ModelMap modelMap){
        UserInfo userById = userInfoService.findUserById(id);
        modelMap.addAttribute("userDetail",userById);
        return "updateUserPage";
    }

    /**
     * 更新用户信息操作
     * */
    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user")UserInfo userInfo){
        String password = userInfo.getPassword();
        userInfo.setPassword(passwordEncoder.encode(password));
        userInfoService.save(userInfo);
        return "redirect:/findAllUser";
    }

    /**
     * 删除用户
     * */
    @GetMapping("/delete")
    public String deleteUserByid(Integer id){
        userInfoService.deleteUserById(id);
        return "redirect:/findAllUser";
    }

}
