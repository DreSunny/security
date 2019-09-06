package com.sunny.security.controller;

import com.sunny.security.permission.bean.BlogEntity;
import com.sunny.security.permission.bean.UserInfo;
import com.sunny.security.service.BlogService;
import com.sunny.security.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author: 孙宇豪
 * @Date: 2019/9/3 17:07
 * @Description: TODO
 * @Version 1.0
 */
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 博客列表
     * */
    @GetMapping("findAllBlog")
    public String findAllBlog(Model model){
        List<BlogEntity> allBlogs = blogService.findAllBlogs();
        model.addAttribute("blogs",allBlogs);
        return "blog/blogPage";
    }

    /**
     * 博客详情
     * */
    @GetMapping("blogDetail")
    public String blogDetail(Integer id,ModelMap modelMap){
        BlogEntity blogById = blogService.findBlogById(id);
        modelMap.addAttribute("blog",blogById);
        return "blog/blogDetail";
    }

    /**
     * 添加博客 页面
     */
    @GetMapping("addBlogPage")
    public String addBlogPage(ModelMap modelMap){
        List<UserInfo> allUser = userInfoService.findAllUser();
        modelMap.addAttribute("users",allUser);
        return "blog/addBlogPage";
    }

    /**
     * 添加博客
     * */
    @PostMapping("addBlog")
    public String addBlog(@ModelAttribute("blog")BlogEntity blogEntity){
        blogEntity.setType("1");
        blogService.save(blogEntity);
        return "redirect:/findAllBlog";
    }

    /**
     * 修改博客页面
     * */
    @GetMapping("uploadBlogPage")
    public String uploadBlogPage(Integer id,ModelMap modelMap){
        BlogEntity blogById = blogService.findBlogById(id);
        List<UserInfo> allUser = userInfoService.findAllUser();
        modelMap.addAttribute("blog",blogById);
        modelMap.addAttribute("users",allUser);
        return "blog/uploadBlogPage";
    }

    /**
     * 修改博客
     * */
    @PostMapping("uploadBlog")
    public String uploadBlog(BlogEntity blogEntity){
        blogEntity.setType("1");
        blogService.save(blogEntity);
        return "redirect:findAllBlog";
    }

    /**
     * 删除博客
     * */
    @GetMapping("deleteBlog")
    public String deleteBlog(Integer id){
        blogService.deleteById(id);
        return "redirect:findAllBlog";
    }




}
