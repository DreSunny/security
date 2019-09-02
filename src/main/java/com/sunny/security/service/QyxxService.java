package com.sunny.security.service;


import com.sunny.security.dao.QyxxMapper;
import com.sunny.security.entity.Qyxx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 孙宇豪
 * @Date: 2019/5/22 15:44
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class QyxxService {

    @Autowired
    private QyxxMapper qyxxMapper;

    public List<Qyxx> findAll(){
        List<Qyxx> all = this.qyxxMapper.findAll();
        return all;
    }
}
