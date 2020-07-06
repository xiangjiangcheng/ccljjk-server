package com.ccljjk.server.model.response;

import lombok.Data;


/**
 * 用户详情
 */
@Data
public class UserDetailResponse {

    private Long id;

    private String name;

    private Integer age;

    private String email;

}
