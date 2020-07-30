package com.ccljjk.server.model.validator;

import com.ccljjk.server.config.exception.BusinessException;
import com.ccljjk.server.model.enums.ErrorEnums;
import com.ccljjk.server.model.request.UserFormRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 用户校验器 - 参数若不对，直接抛出自定义异常{@link BusinessException}即可，因为异常全局拦截了
 */
@Component
public class UserValidator {

    public void validateUserFormRequest(UserFormRequest request) {
        if (request == null) {
            throw new BusinessException(ErrorEnums.PARAM_NOT_ENOUGH);
        }

        String name = request.getName();
        if (StringUtils.isEmpty(name)) {
            throw new BusinessException(ErrorEnums.PARAM_IS_EMPTY.getResultCode(), "用户姓名为空");
        }
    }
}
