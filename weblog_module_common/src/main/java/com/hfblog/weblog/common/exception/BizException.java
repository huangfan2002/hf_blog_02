package com.hfblog.weblog.common.exception;

import lombok.Getter;
import lombok.Setter;


//自定义业务异常 BizException
//我们让 BizException 继承自运行时异常 RuntimeException, 同时定义了两个基本字段：
//        errorCode : 异常码；
//        errorMessage: 错误信息，用于提供给调用者；
//另外，还定义了一个构造器，入参是前面创建的 BaseExceptionInterface，
//通过它可以方便的构造一个业务异常。
@Getter
@Setter
public class BizException extends RuntimeException {
    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;

    public BizException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }


}