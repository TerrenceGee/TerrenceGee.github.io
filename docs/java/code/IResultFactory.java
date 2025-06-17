package com.iie.extract.common;


/**
 * 返回结果工具类
 */
public class IResultFactory<T> {
    public static <T> IResult<T> success() {
        return IResult.<T>builder()
            .code(IResultCode.SUCCESS.code())
            .message(IResultCode.SUCCESS.message())
            .build();
    }

    public static <T> IResult<T> success(IResultCode resultCode) {
        return IResult.<T>builder()
            .code(resultCode.code())
            .message(resultCode.message())
            .build();
    }

    public static <T> IResult<T> success(T data) {
        return IResult.<T>builder()
            .code(IResultCode.SUCCESS.code())
            .message(IResultCode.SUCCESS.message())
            .data(data)
            .build();
    }

    public static <T> IResult<T> error(IResultCode code) {
        return IResult.<T>builder()
            .code(IResultCode.SUCCESS.code())
            .message(IResultCode.SUCCESS.message())
            .data(null)
            .build();
    }

    public static <T> IResult<T> error(IResultCode code, String extra) {
        return IResult.<T>builder()
            .code(IResultCode.SUCCESS.code())
            .message(IResultCode.SUCCESS.message())
            .data(null)
            .extra(extra)
            .build();
    }

    public static <T> IResult<T> error(Integer code, String message) {
        return IResult.<T>builder()
            .code(code)
            .message(message)
            .data(null)
            .build();
    }

}
