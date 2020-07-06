package com.ccljjk.server.config;

import com.ccljjk.server.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 拦截器，用于请求记录监控，打印并记录请求信息的日志
 *
 * @Author Xiang Jiangcheng
 */
@Component
public class AuthorInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(AuthorInterceptor.class);

    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("StartTime-EndTime");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            //记录开始时间
            startTimeThreadLocal.set(System.currentTimeMillis());
            // RegisterRequest uri = request.getRequestURI();
            // return sysCheck( request,  response, uri);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long startTime = startTimeThreadLocal.get();
        Long endTime = System.currentTimeMillis();
        Long hs = endTime - startTime;
        String uri = request.getRequestURI();
        Map<String, String[]> parameterMap = request.getParameterMap();
        logger.info("uri : {}, hs : {} ms, parameter : {}", uri, hs, GsonUtils.toJson(parameterMap));
    }
}
