package com.ccljjk.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public void insertOrUpdate(UserFormRequest request) {
        log.info("进入方法insertOrUpdate() ---> 新增/修改用户--->");

        String phone = request.getPhone();

        if (request.isAdd()) {
            // 新增
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("phone", phone);

            int count = this.count(queryWrapper);
            if (count > 0) {
                throw new BusinessException(ErrorEnums.USER_IS_EXISTS);
            }

            User user = userAssembler.toUser(request);

            this.save(user);
        } else {
            // 修改
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("phone", phone);
            User user = this.getOne(queryWrapper);
            if (user == null) {
                throw new BusinessException(ErrorEnums.NO_USER);
            }
            userAssembler.toUpdateUser(user, request);
            this.updateById(user);
        }
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
