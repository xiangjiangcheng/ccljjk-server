package com.ccljjk.server.config.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * 扩展用户信息，存放自定义字段
 *
 * @author Xiang Jiangcheng
 * @date 2020/7/31 14:30
 */
@Data
public class LoginUser extends User implements UserDetails {

    public static final String ANONYMOUS_USER_NAME = "Anonymous user";

    private String name;

    private String phone;

    private String gender;

    private int age;

    public LoginUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public LoginUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String name, String phone, String gender, int age) {
        super(username, password, authorities);
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
    }


    /**
     * 匿名用户
     */
    public static LoginUser anonymousUser() {
        return new LoginUser(ANONYMOUS_USER_NAME, "", Collections.EMPTY_LIST);
    }

}
