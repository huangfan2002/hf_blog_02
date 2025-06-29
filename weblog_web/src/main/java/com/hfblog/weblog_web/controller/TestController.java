package com.hfblog.weblog_web.controller;

import com.hfblog.weblog.common.aspect.ApiOperationLog;
import com.hfblog.weblog.common.enums.ResponseCodeEnum;
import com.hfblog.weblog.common.exception.BizException;
import com.hfblog.weblog.common.utils.Response;
import com.hfblog.weblog_web.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

@RestController


@Slf4j
public class TestController {
    @GetMapping("/")
    public String index() {
        return "服务已启动，欢迎使用 Weblog 博客系统！";
    }


//    @PostMapping("/test")
//    @ApiOperationLog(description = "测试接口")
//    public Response test(@RequestBody @Validated User
//    user, BindingResult bindingResult) {
//        // 是否存在校验错误
//        if (bindingResult.hasErrors()) {
//            // 获取校验不通过字段的提示信息
//            String errorMsg = bindingResult.getFieldErrors()
//                    .stream()
//                    .map(FieldError::getDefaultMessage)
//                    .collect(Collectors.joining(", "));
//
//            return Response.fail(errorMsg);
//        }
//
//        // 返参
//        return Response.success();
//    }

    //    @PostMapping("/test")
//    @ApiOperationLog(description = "测试接口")
//    public Response test(@RequestBody @Validated User user, BindingResult bindingResult) {
//        // 手动抛异常，入参是前面定义好的异常码枚举，返参统一交给全局异常处理器搞定
//        throw new BizException(ResponseCodeEnum.PRODUCT_NOT_FOUND);
    /*    } */
    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public Response test(@RequestBody @Validated User user, BindingResult bindingResult) {/* 主动定义一个运行时异常，分母不能为零 */
        int i = 1 / 0;
        return Response.success();
    }


//    @PostMapping("/test")
//    @ApiOperationLog(description = "测试接口")
//    public User test(@RequestBody User user) {
//        // 返参
//        return user;
    /*    } */


}
