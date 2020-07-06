package com.ccljjk.server.model;

import com.ccljjk.server.model.constant.Constants;
import com.ccljjk.server.model.enums.ErrorEnums;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 全局返回结果
 *
 * @author Xiang Jiangcheng
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = -2581315945152978711L;

    private T data;

    private String code;

    private String message;

    public ResponseResult(T data, String code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public ResponseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseResult ok() {
        return new ResponseResult(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE);
    }

    public static <T> ResponseResult ok(T data) {
        return new ResponseResult<>(data, Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE);
    }

    public static ResponseResult error(String status, String msg) {
        return new ResponseResult(status, msg);
    }

    public static ResponseResult error(ErrorEnums error) {
        return new ResponseResult(error.getResultCode(), error.getResultMsg());
    }

    public static ResponseResult result(String status, String msg) {
        return new ResponseResult(status, msg);
    }

    public static <T> ResponseResult result(T data, String status, String msg) {
        return new ResponseResult(data, status, msg);
    }
}
