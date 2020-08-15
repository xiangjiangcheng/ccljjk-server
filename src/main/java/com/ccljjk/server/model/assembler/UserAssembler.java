package com.ccljjk.server.model.assembler;

import com.ccljjk.server.entity.User;
import com.ccljjk.server.model.request.UserFormRequest;
import com.ccljjk.server.model.response.UserDetailResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public User toUser(UserFormRequest request) {
        if (request != null) {
            User user = new User();

            String phone = request.getPhone();
            user.setName(request.getName());
            user.setPhone(phone);
            user.setAge(request.getAge());
            user.setRole(request.getRole());
            user.setGender(request.getGender());
            user.setEmail(request.getEmail());
            user.setDeleted(0);

            // 密码
            // 进行强哈希加密
            String password = request.getPassword();
            if (StringUtils.isEmpty(password)) {
                // 没设置密码，默认取手机号后六位
                password = phone.substring(5);
            }
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(password.trim()));

            return user;
        }

        return null;
    }

    public void toUpdateUser(User user, UserFormRequest request) {
        if (request != null) {
            user.setName(request.getName());
            user.setGender(request.getGender());
            user.setRole(request.getRole());
            user.setEmail(request.getEmail());
            user.setAge(request.getAge());
        }
    }
}
