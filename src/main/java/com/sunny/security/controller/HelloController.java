package com.sunny.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 孙宇豪
 * @Date: 2019/7/26 16:13
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String getWelcomeMsg() {
        return "Hello,Spring Security";
    }

    /**
     * PreAuthorize("hasAnyRole('admin')")
     * 此注解是配置Securiry开启方法级安全验证
     * */
    @GetMapping("/helloAdmin")
//    @PreAuthorize("hasAnyRole('admin')")
    public String helloAdmin() {
        return "Hello,admin,let us go!!!!!";
    }

    @GetMapping("/helloUser")
//    @PreAuthorize("hasAnyRole('admin','normal')")
    public String helloUser() {
        return "Hello,user";
    }
 }
