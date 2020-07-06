package com.ccljjk.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccljjk.server.config.exception.BusinessException;
import com.ccljjk.server.entity.User;
import com.ccljjk.server.mapper.UserMapper;
import com.ccljjk.server.model.assembler.UserAssembler;
import com.ccljjk.server.model.enums.ErrorEnums;
import com.ccljjk.server.model.request.UserFormRequest;
import com.ccljjk.server.model.response.UserDetailResponse;
import com.ccljjk.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Jiangcheng Xiang
 */
@Slf4j
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserAssembler userAssembler;

    @Override
    public int addUser(UserFormRequest request) {
        log.info("新增用户--->");
        return 0;
    }

    @Override
    public UserDetailResponse getUserDetailById(String userId) {
        User user = this.getById(userId);

        if (user == null) {
            throw new BusinessException(ErrorEnums.NO_USER);
        }
        // 处理结果
        return userAssembler.toUserDetailResponse(user);
    }
}
