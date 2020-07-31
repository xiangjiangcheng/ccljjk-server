package com.ccljjk.server.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccljjk.server.entity.User;
import com.ccljjk.server.model.ResponseResult;
import com.ccljjk.server.model.request.UserFormRequest;
import com.ccljjk.server.model.response.UserDetailResponse;
import com.ccljjk.server.model.validator.UserValidator;
import com.ccljjk.server.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 *
 * @Author Xiang Jiangcheng
 */
@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('USER')")
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
        Page<User> page = new Page<>(pageNumber, pageSize);
        Page<User> users = userService.page(page);
        return ResponseResult.ok(users);
    }

    /**
     * 新增或者修改用户
     *
     * @param request 新增/修改用户参数
     * @return response
     */
    @PostMapping("/insertOrUpdate")
    public ResponseResult insertOrUpdate(@RequestBody UserFormRequest request) {

        // 先校验请求参数，参数不对，直接抛异常BusinessException
        userValidator.validateUserFormRequest(request);

        // 业务处理
        userService.insertOrUpdate(request);

        // 返回结果
        return ResponseResult.ok();
    }

    /**
     * 根据用户ID获取用户详情
     *
     * @param userId 用户ID
     * @return 用户详情
     */
    @GetMapping(value = "/{userId}", produces = "text/plain;charset=UTF-8")
    public ResponseResult get(@PathVariable("userId") String userId) {

        // 业务处理
        UserDetailResponse response = userService.getUserDetailById(userId);

        // 返回结果
        return ResponseResult.ok(response);
    }



}
