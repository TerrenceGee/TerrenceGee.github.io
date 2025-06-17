package com.iie.extract.common.exception;

import com.iie.extract.common.IResultCode;
import com.iie.extract.common.IResultFactory;
import com.iie.extract.common.IResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 全局异常异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 如果超过长度，则前后段交互体验不佳，使用默认错误消息
     */
    static Integer MAX_LENGTH = 200;

    /**
     * 自定义异常
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public IResult<Object> handleServiceException(HttpServletRequest request,
                                                  final ServiceException e,
                                                  HttpServletResponse response) {
        //如果是自定义异常，则获取异常，返回自定义错误消息
        if (e != null) {
            IResultCode IResultCode = e.getIResultCode();
            Integer code = null;
            String message = null;

            if (IResultCode != null) {
                code = IResultCode.code();
                message = IResultCode.message();
            }
            //如果有扩展消息，则输出异常中，跟随补充异常
            if (!e.getMsg().equals(ServiceException.DEFAULT_MESSAGE)) {
                message += ":" + e.getMsg();
            }

            log.error("全局异常[ServiceException]:{}-{}", e.getIResultCode().code(), e.getIResultCode().message(), e);
            return IResultFactory.error(code, message);

        } else {
            log.error("全局异常[ServiceException]:", (Throwable) null);
        }

        //默认错误消息
        String errorMsg = "服务器异常，请稍后重试";
        if (e != null && e.getMessage() != null && e.getMessage().length() < MAX_LENGTH) {
            errorMsg = e.getMessage();
        }
        return IResultFactory.error(IResultCode.ERROR.code(), errorMsg);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public IResult<Object> runtimeExceptionHandler(HttpServletRequest request, final RuntimeException e,
                                                   HttpServletResponse response) {
        log.error("全局异常[RuntimeException]:", e);
        return IResultFactory.error(IResultCode.ERROR);
    }

    /**
     * bean校验未通过异常
     *
     * @see javax.validation.Valid
     * @see org.springframework.validation.Validator
     * @see org.springframework.validation.DataBinder
     */
    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public IResult<Object> validExceptionHandler(HttpServletRequest request, final BindException e,
                                                 HttpServletResponse response) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            return IResultFactory.error(IResultCode.PARAMS_ERROR.code(), error.getDefaultMessage());
        }
        return IResultFactory.error(IResultCode.PARAMS_ERROR);
    }

}
