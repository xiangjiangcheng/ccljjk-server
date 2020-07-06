package com.ccljjk.server.config.exception;

import com.ccljjk.server.model.ResponseResult;
import com.ccljjk.server.model.enums.ErrorEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("未知异常 ---> 原因是:", e);
        return ResponseResult.error(ErrorEnums.INTERNAL_SERVER_ERROR);
    }

}
