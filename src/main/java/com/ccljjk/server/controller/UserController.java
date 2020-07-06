package com.ccljjk.server.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccljjk.server.config.exception.BusinessException;
import com.ccljjk.server.entity.User;
import com.ccljjk.server.model.ResponseResult;
import com.ccljjk.server.model.enums.ErrorEnums;
import com.ccljjk.server.model.request.UserFormRequest;
import com.ccljjk.server.model.response.UserDetailResponse;
import com.ccljjk.server.model.validator.UserValidator;
import com.ccljjk.server.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 *
 * @Author Jiangcheng Xiang
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    /**
     * 分页查询用户列表
     *
     * @param pageNumber 页码
     * @param pageSize   每页条数
     * @return list
     */
    @GetMapping("")
    public ResponseResult userList(@Param("pageNumber") int pageNumber, @Param("pageSize") int pageSize) {
        boolean flag = true;
        if (flag) {
            throw new BusinessException(ErrorEnums.NO_USER);
        }
        Page<User> page = new Page<>(pageNumber, pageSize);
        Page<User> users = userService.page(page);
        return ResponseResult.ok(users);
    }

    /**
     * 新增用户
     *
     * @param request 新增用户参数
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseResult add(@RequestBody UserFormRequest request) {

        // 先校验请求参数，参数不对，直接抛异常BusinessException
        userValidator.validateUserFormRequest(request);

        // 业务处理
        userService.addUser(request);

        // 返回结果
        return ResponseResult.ok();
    }

    /**
     * 根据用户ID获取用户详情
     *
     * @param userId 用户ID
     * @return 用户详情
     */
    @GetMapping("/{userId}")
    public ResponseResult get(@PathVariable("userId") String userId) {

        // 业务处理
        UserDetailResponse response = userService.getUserDetailById(userId);

        // 返回结果
        return ResponseResult.ok(response);
    }


}
