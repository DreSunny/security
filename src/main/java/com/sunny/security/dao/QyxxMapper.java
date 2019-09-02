package com.sunny.security.dao;

import com.sunny.security.entity.Qyxx;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: 孙宇豪
 * @Date: 2019/5/22 15:35
 * @Description: TODO
 * @Version 1.0
 */
@Mapper
public interface QyxxMapper {

    @Select("select * from qyxx limit 10")
    List<Qyxx> findAll();


}
