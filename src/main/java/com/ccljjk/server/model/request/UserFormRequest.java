package com.ccljjk.server.model.request;


import lombok.Data;


/**
 * 新增/修改用户实体类 - 接收前端传参
 */
@Data
public class UserFormRequest {

    private String name;

    private int age;

}
