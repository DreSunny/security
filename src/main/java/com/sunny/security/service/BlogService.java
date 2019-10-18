package com.sunny.security.service;

import com.sunny.security.dao.BlogDao;
import com.sunny.security.permission.bean.BlogEntity;
import com.sunny.security.utils.CoreDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: 孙宇豪
 * @Date: 2019/9/3 17:28
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class BlogService {

    @Autowired
    private BlogDao blogDao;

    public List<BlogEntity> findAllBlogs(){
         return blogDao.findAll();
    }

    public void save(BlogEntity blogEntity){
        blogEntity.setCreateTime(CoreDateUtils.formatDateTime(new Date()));
        blogEntity.setUpdateTime(CoreDateUtils.formatDateTime(new Date()));
        blogDao.saveAndFlush(blogEntity);
    }

    public void update(BlogEntity blogEntity){
        blogEntity.setUpdateTime(CoreDateUtils.formatDateTime(new Date()));
        blogDao.saveAndFlush(blogEntity);
    }

    public BlogEntity findBlogById(Integer id){
        return blogDao.findById(id);
    }

    public void deleteById(Integer id){
        blogDao.deleteById(id);
        blogDao.flush();
    }


}
