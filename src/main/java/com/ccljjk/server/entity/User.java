package com.ccljjk.server.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 */
@Data
@Accessors(chain = true)
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户姓名
     */
    @TableField("name")
    private String name;

    /**
     * 手机号，用户登录时输入的用户名
     */
    @TableField("phone")
    private String phone;

    /**
     * 登录密码
     */
    @TableField("password")
    private String password;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 性别 性别 F: 女 M:男
     */
    @TableField("gender")
    private String gender;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 用户角色  ADMIN:超级管理员  USER:普通用户
     */
    @TableField("role")
    private String role;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;

    /**
     * 最后修改时间
     */
    @TableField("modified_time")
    private Date modifiedTime;

    /**
     * 删除标志： 1删除  0：未删除
     */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;


}
