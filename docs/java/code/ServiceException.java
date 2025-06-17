package com.iie.extract.common.exception;

import com.iie.extract.common.IResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 全局业务异常类
 *
 * @author Chopper
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "网络错误，请稍后重试！";
    private static final long serialVersionUID = 3447728300174142127L;
    /**
     * 异常消息
     */
    private String msg = DEFAULT_MESSAGE;

    /**
     * 错误码
     */
    private IResultCode IResultCode;

    public ServiceException(String msg) {
        this.IResultCode = com.iie.extract.common.IResultCode.ERROR;
        this.msg = msg;
    }

    public ServiceException() {
        super();
    }

    public ServiceException(IResultCode IResultCode) {
        this.IResultCode = IResultCode;
    }

    public ServiceException(IResultCode IResultCode, String message) {
        this.IResultCode = IResultCode;
        this.msg = message;
    }

}
