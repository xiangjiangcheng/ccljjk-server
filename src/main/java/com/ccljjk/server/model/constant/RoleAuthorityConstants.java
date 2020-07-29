package com.ccljjk.server.model.constant;

/**
 *
 * 角色对应的权限 -- 映射类
 *
 * 目前只有两种角色： 1.超级管理员  2.普通用户
 *
 * 注意，若新增的controller访问需要权限，需要将对应的权限加到这里，且以ROLE_开头
 *
 */
public class RoleAuthorityConstants {

    /**
     * 超级管理员
     */
    public static String ADMIN = "ROLE_ORDER,ROLE_USER,ROLE_DEMO";

    /**
     * 普通用户
     */
    public static String USER = "ROLE_ORDER";
}
