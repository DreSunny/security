package com.sunny.security.fitter;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @Author: 孙宇豪
 * @Date: 2019/7/30 10:04
 * @Description: TODO 在 atFilter 相同位置添加 filter， 此 filter 不覆盖 filter
 * @Version 1.0
 */
public class AtLoginFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("this is a filter at UsernamePasswordAuthenticationFilter.");
        //继续调用Filter链
        chain.doFilter(request, response);
    }
}