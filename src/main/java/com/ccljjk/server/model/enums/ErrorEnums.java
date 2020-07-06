package com.ccljjk.server.model.enums;

/**
 * 异常枚举类
 *
 * @author Xiang Jiangcheng
 * @date 2020/6/29 14:19
 */
public enum ErrorEnums {

    /**
     * 数据操作错误定义
     */
    SUCCESS("200", "成功!"),

    BODY_NOT_MATCH("400", "请求的数据格式不符!"),

    SIGNATURE_NOT_MATCH("401", "请求的数字签名不匹配!"),

    NOT_FOUND("404", "未找到该资源!"),

    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),

    SERVER_BUSY("503", "服务器正忙，请稍后再试!"),

    /**
     * 其他业务错误定义
     */
    PARAM_IS_EMPTY("10000", "参数为空"),

    PARAM_NOT_ENOUGH("11000", "参数不足"),

    NO_USER("1000", "用户不存在");

    /**
     * 错误码
     */
    private String resultCode;
    /**
     * 错误描述
     */
    private String resultMsg;

    ErrorEnums(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
