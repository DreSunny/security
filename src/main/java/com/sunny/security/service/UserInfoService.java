package com.sunny.security.service;


import com.sunny.security.permission.bean.UserInfo;
import com.sunny.security.permission.repository.UserInfoRepository;
import jdk.nashorn.internal.runtime.ECMAException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 孙宇豪
 * @Date: 2019/7/26 16:58
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }

    public List<UserInfo> findAllUser(){
        List<UserInfo> all = userInfoRepository.findAll();
        return all;
    }

    public void save(UserInfo userInfo){
        try {
            userInfoRepository.saveAndFlush(userInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public UserInfo findUserById(Integer id){
        try {
            UserInfo byUid = userInfoRepository.findByUid(id.longValue());
            return byUid;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void deleteUserById(Integer id){
        try {
            userInfoRepository.deleteById(id.longValue());
            userInfoRepository.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
