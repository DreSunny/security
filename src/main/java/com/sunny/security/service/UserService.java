package com.sunny.security.service;


import com.sunny.security.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 孙宇豪
 * @Date: 2019/5/22 15:21
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {


        return userMapper.findAll();
    }

    public int add(User user) {

        return userMapper.add(user);

    }

}