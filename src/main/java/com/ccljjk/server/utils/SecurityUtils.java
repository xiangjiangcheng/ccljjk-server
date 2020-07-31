package com.ccljjk.server.utils;

import com.ccljjk.server.config.security.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * security工具类，获取用户信息
 *
 * @author Xiang Jiangcheng
 */
public abstract class SecurityUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUtils.class);

    public static LoginUser currentUser() {
        LoginUser anonymousUser = LoginUser.anonymousUser();
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof LoginUser) {
                return (LoginUser) principal;
            } else {
                return anonymousUser;
            }
        } catch (Exception e) {
            LOGGER.warn("Get current user failed!", e);
            return anonymousUser;
        }
    }

    public static void update(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}