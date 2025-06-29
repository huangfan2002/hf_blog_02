package com.hfblog.weblog.common.exception;

import com.hfblog.weblog.common.enums.ResponseCodeEnum;
import com.hfblog.weblog.common.utils.Response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


//上述代码中，通过 @ControllerAdvice 注解，
// 我们将 GlobalExceptionHandler 声明为了全局异常处理类。
// 在其中，定义了一个 handleBizException() 方法，
// 并通过 @ExceptionHandler 注解指定只捕获 BizException 自定义业务异常。
// 然后，打印了相关错误日志，并组合了统一的响应格式返回。
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({ BizException.class })
    @ResponseBody
    public Response<Object> handleBizException(HttpServletRequest request, BizException e) {
        log.warn("{} request fail, errorCode: {}, errorMessage: {}", request.getRequestURI(), e.getErrorCode(), e.getErrorMessage());
        return Response.fail(e);
    }

    /**
     * 其他类型异常
     * @param request
     * @param e
     * @return
     */
//    上述代码中，通过 @ExceptionHandler({ Exception.class }) ,
//    捕获的是通用的 Exception 异常，你可能会好奇，处理器最终会使用哪个方法进行捕获呢？
//    举个栗子，比如你定义了捕获具体的异常的方法，如 BizException，
//    假设抛出的异常也与之对应，则优先使用它来处理，
//    否则使用 @ExceptionHandler({ Exception.class }) 定义的方法。
    @ExceptionHandler({ Exception.class })
    @ResponseBody
    public Response<Object> handleOtherException(HttpServletRequest request, Exception e) {
        log.error("{} request error, ", request.getRequestURI(), e);
        return Response.fail(ResponseCodeEnum.SYSTEM_ERROR);
//        return Response.fail(String.valueOf(ResponseCodeEnum.SYSTEM_ERROR));
    }

}
