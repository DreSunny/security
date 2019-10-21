package com.sunny.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 孙宇豪
 * @Date: 2019/10/16 16:21
 * @Description: TODO 医院控制器
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "hospital")
public class HospitalController {

    @GetMapping("/index")
    public String blogIndex(){
        return "hospital/index";
    }

    @GetMapping("hospitalShow")
    public String HospitalShow(){
        return "hospital/hospitalShow";
    }

}
