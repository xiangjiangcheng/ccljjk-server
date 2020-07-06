package com.ccljjk.server.config.exception;

import com.ccljjk.server.model.enums.ErrorEnums;
import lombok.Data;

/**
 * 自定义异常类，用于处理我们发生的业务异常。
 *
 * @author Xiang Jiangcheng
 * @date 2020/6/29 14:15
 */
@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected String errorCode;

    /**
     * 错误信息
     */
    protected String errorMsg;

    public BusinessException() {
        super();
    }

    public BusinessException(ErrorEnums error) {
        super(error.getResultCode());
        this.errorCode = error.getResultCode();
        this.errorMsg = error.getResultMsg();
    }

    public BusinessException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BusinessException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BusinessException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


}
