package com.ccljjk.server.model.assembler;

import com.ccljjk.server.entity.User;
import com.ccljjk.server.model.response.UserDetailResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


/**
 * 用户实体转换类   po -> vo   vo -> po
 */
@Component
public class UserAssembler {

    /**
     * 用户实体转用户详情，返回给前端
     *
     * @param user
     * @return
     */
    public UserDetailResponse toUserDetailResponse(User user) {
        if (user != null) {
            UserDetailResponse response = new UserDetailResponse();
            BeanUtils.copyProperties(user, response);
            return response;
        }
        return null;
    }
}
