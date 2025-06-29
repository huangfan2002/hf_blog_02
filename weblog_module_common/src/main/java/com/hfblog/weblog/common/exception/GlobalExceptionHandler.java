package com.hfblog.weblog.common.exception;

import com.hfblog.weblog.common.enums.ResponseCodeEnum;
import com.hfblog.weblog.common.utils.Response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


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


    /**
     * 捕获参数校验异常
     * @return
     */

//    上述代码中，我们通过 @ExceptionHandler 注解捕获了 MethodArgumentNotValidException.class
//    类型的异常，并从异常实体类中获取了 BindingResult 对象，
//    从而获取到具体哪些字段校验不通过，最终组合错误信息并返回。
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    @ResponseBody
    public Response<Object> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        // 参数错误异常码
        String errorCode = ResponseCodeEnum.PARAM_NOT_VALID.getErrorCode();

        // 获取 BindingResult
        BindingResult bindingResult = e.getBindingResult();

        StringBuilder sb = new StringBuilder();

        // 获取校验不通过的字段，并组合错误信息，格式为： email 邮箱格式不正确, 当前值: '123124qq.com';
        Optional.ofNullable(bindingResult.getFieldErrors()).ifPresent(errors -> {
            errors.forEach(error ->
                    sb.append(error.getField())
                            .append(" ")
                            .append(error.getDefaultMessage())
                            .append(", 当前值: '")
                            .append(error.getRejectedValue())
                            .append("'; ")

            );
        });

        // 错误信息
        String errorMessage = sb.toString();

        log.warn("{} request error, errorCode: {}, errorMessage: {}", request.getRequestURI(), errorCode, errorMessage);

        return Response.fail(errorCode, errorMessage);
    }




}
