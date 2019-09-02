package com.sunny.security.permission.repository;



import com.sunny.security.permission.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 孙宇豪
 * @Date: 2019/7/29 17:53
 * @Description: TODO
 * @Version 1.0
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

}