package com.ccljjk.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccljjk.server.entity.User;
import com.ccljjk.server.mapper.UserMapper;
import com.ccljjk.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author Jiangcheng Xiang
 */
@Slf4j
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public int addUser() {
        log.info("新增用户--->");
        return 0;
    }
}
