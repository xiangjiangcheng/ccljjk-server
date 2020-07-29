package com.ccljjk.server.config.exception;

import com.ccljjk.server.model.ResponseResult;
import com.ccljjk.server.model.enums.ErrorEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 *
 * @author Xiang Jiangcheng
 * @date 2020/6/29 13:51
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseResult BusinessExceptionHandler(HttpServletRequest request, BusinessException e) {
        log.error("发生业务异常 ---> 原因是：{}", e.getErrorMsg());
        return ResponseResult.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResponseResult exceptionHandler(HttpServletRequest request, NullPointerException e) {
        log.error("发生空指针异常 ---> 原因是:", e);
        return ResponseResult.error(ErrorEnums.BODY_NOT_MATCH);
    }


    /**
     * 处理其他异常
     *
     * 由于加入了security之后，如果仍然拦截Exception,则会拦截security的相关异常，所以，这里暂时注释掉！！！，只拦截自定义异常和空指针异常！！！
     *
     * @param request
     * @param e
     * @return
     */
    // @ExceptionHandler(value = Exception.class)
    // @ResponseBody
    // public ResponseResult exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
    //
    //     log.error("未知异常 ---> 原因是:", e);
    //
    //     // 处理特殊的security的异常
    //     if (e instanceof AccessDeniedException) {
    //         log.error("拒绝访问 ---> 原因是: 登录过期或未登录!", e);
    //         // 拒绝访问
    //         return ResponseResult.error(ErrorEnums.ACCESS_DENIED);
    //     }
    //
    //     return ResponseResult.error(ErrorEnums.INTERNAL_SERVER_ERROR);
    // }

}
