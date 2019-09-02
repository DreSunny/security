package com.sunny.security.permission.repository;


import com.sunny.security.permission.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 孙宇豪
 * @Date: 2019/7/30 11:16
 * @Description: TODO
 * @Version 1.0
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}