package com.sunny.security.dao;

import com.sunny.security.permission.bean.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * @Author: 孙宇豪
 * @Date: 2019/9/3 17:26
 * @Description: TODO
 * @Version 1.0
 */
@Transactional
public interface BlogDao extends JpaRepository<BlogEntity,Long> {
    BlogEntity findById(Integer id);

    void deleteById(Integer id);
}
