package com.ccljjk.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ccljjk.server.entity.User;
import org.apache.ibatis.annotations.Mapper;

// @Mapper
public interface UserMapper extends BaseMapper<User> {

    User findUserByName(String name);

}
