package com.ccljjk.server.config.security;

import com.ccljjk.server.mapper.UserMapper;
import com.ccljjk.server.model.constant.RoleAuthorityConstants;
import com.ccljjk.server.model.constant.RoleConstants;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 自定义用户实现类
 */
@Data
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 这里可以捕获异常，使用异常映射，抛出指定的提示信息
        if (username == null || username.trim().length() <= 0) {
            throw new UsernameNotFoundException("用户名为空");
        }

        // 从数据库查询用户
        com.ccljjk.server.entity.User user = userMapper.findUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在!");
        }
        String password = user.getPassword();

        // 根据用户角色查询用户权限
        List<String> roleList;
        if (RoleConstants.ADMIN.equals(user.getRole())) {
            roleList = Arrays.asList(RoleAuthorityConstants.ADMIN.split(","));
        } else {
            roleList = Arrays.asList(RoleAuthorityConstants.USER.split(","));
        }

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        /*
         * Spring Boot 2.0 版本踩坑
         * 必须要 ROLE_ 前缀， 因为 hasRole("LEVEL1")判断时会自动加上ROLE_前缀变成 ROLE_LEVEL1 ,
         * 如果不加前缀一般就会出现403错误
         * 在给用户赋权限时,数据库存储必须是完整的权限标识ROLE_LEVEL1
         */
        if (roleList.size() > 0) {
            for (String role : roleList) {
                grantedAuthorityList.add(new SimpleGrantedAuthority(role));
            }
        }

        String name = user.getName();
        String gender = user.getGender();
        Integer age = user.getAge();
        return new LoginUser(username, password, grantedAuthorityList, name, username, gender, age);
    }
}