package com.ccljjk.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ccljjk.server.entity.User;

/**
 * @Author: Xiang Jiangcheng
 */
public interface UserService extends IService<User> {

    /**
     * 自定义的添加接口
     *
     * @return
     */
    int addUser();

}
