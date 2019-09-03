package com.sunny.security.permission.repository;


import com.sunny.security.permission.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * @Author: 孙宇豪
 * @Date: 2019/7/26 16:57
 * @Description: TODO
 * @Version 1.0
 */
@Transactional
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

    public UserInfo findByUsername(String username);

    public UserInfo findByUid(Long uid);


}