package com.ccljjk.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ccljjk.server.entity.User;
import com.ccljjk.server.model.request.UserFormRequest;
import com.ccljjk.server.model.response.UserDetailResponse;

/**
 * @Author: Xiang Jiangcheng
 */
public interface UserService extends IService<User> {

    /**
     * 自定义的添加接口
     *
     * @return
     * @param request
     */
    int addUser(UserFormRequest request);

    UserDetailResponse getUserDetailById(String userId);
}
