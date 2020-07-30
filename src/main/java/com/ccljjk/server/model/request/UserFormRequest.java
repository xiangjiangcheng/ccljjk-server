package com.ccljjk.server.model.request;


import lombok.Data;


/**
 * 新增/修改用户实体类 - 接收前端传参
 */
@Data
public class UserFormRequest {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码，若未设置，默认为手机号后6位
     */
    private String password;

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private int age;

    /**
     * 角色
     */
    private String role;

    public boolean isAdd() {
        return id == null;
    }

}
