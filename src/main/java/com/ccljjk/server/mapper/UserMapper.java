package com.ccljjk.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ccljjk.server.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// @Mapper
public interface UserMapper extends BaseMapper<User> {

    User findUserByName(String name);

}
