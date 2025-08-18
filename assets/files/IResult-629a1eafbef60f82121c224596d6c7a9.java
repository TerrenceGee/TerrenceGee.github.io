package com.iie.extract.common;


import lombok.*;

import java.io.Serializable;

/**
 * 前后端交互VO
 */
@Getter
@Setter
@Builder
public class IResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    /**
     * 结果对象
     */
    private T data;

    /**
     * 额外信息
     */
    private String extra;

    private long timestamp;
}
