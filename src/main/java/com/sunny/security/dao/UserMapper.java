package com.sunny.security.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * @Author: 孙宇豪
 * @Date: 2019/5/22 15:20
 * @Description: TODO
 * @Version 1.0
 */

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username,password)values(#{username},#{password}")
    public int add(User user);

}
