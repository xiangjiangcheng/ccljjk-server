package com.ccljjk.server.controller;

import com.ccljjk.server.model.ResponseResult;
import com.ccljjk.server.utils.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xiang Jiangcheng
 * @date 2020/7/31 15:05
 */
@RestController
@RequestMapping("/loginUser")
public class LoginUserController {

    /**
     * 获取登录用户信息
     *
     * @return 用户信息
     */
    @GetMapping(value = "/get")
    public ResponseResult get() {

        return ResponseResult.ok(SecurityUtils.currentUser());
    }

}
