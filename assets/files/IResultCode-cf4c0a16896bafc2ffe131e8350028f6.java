package com.iie.extract.common;

/**
 * 返回状态码
 */
public enum IResultCode {

    /**
     * 成功状态码
     */
    SUCCESS(200, "实时查询成功！"),

    /**
     * 失败返回码
     */
    ERROR_AUTHORIZATION(401, "用户权限检验未通过"),
    ERROR_ENTITY_NOT_EXISTS(404, "实体不存在"),
    PARAMS_ERROR(410, "请求中的参数异常"),
    ERROR_OPERATION_ERROR(411, "请求中的操作类型参数异常"),
    ERROR(500, "未知的异常"),
    ;


    private final Integer code;
    private final String message;


    IResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
