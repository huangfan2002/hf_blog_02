package com.hfblog.weblog_web.controller;

import com.hfblog.weblog.common.aspect.ApiOperationLog;
import com.hfblog.weblog.common.enums.ResponseCodeEnum;
import com.hfblog.weblog.common.exception.BizException;
import com.hfblog.weblog.common.utils.JsonUtil;
import com.hfblog.weblog.common.utils.Response;
import com.hfblog.weblog_web.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
//import com.hfblog.weblog.model.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Collectors;




@Slf4j
@RestController
@Api(tags = "首页模块")
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


//    @PostMapping("/test")
//    @ApiOperationLog(description = "测试接口")
//    public Response test(@RequestBody @Validated User user, BindingResult bindingResult) {/* 主动定义一个运行时异常，分母不能为零 */
//        int i = 1 / 0;
//        return Response.success();
//    }


//    为了解决这个问题，Swagger 提供了相关的注解，可以标识模块名称，
//    以及接口名称，并方便的展示在管理界面中。添加方式如下：

//    @PostMapping("/test")
//    @ApiOperationLog(description = "测试接口")
//    @ApiOperation(value = "测试接口")
//    public Response test(@RequestBody @Validated User user) {
//        return Response.success();
//    }

    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    @ApiOperation(value = "测试接口")
    public Response test(@RequestBody @Validated User user) {
        // 打印入参
        log.info(JsonUtil.toJsonString(user));

        // 设置三种日期字段值
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateDate(LocalDate.now());
        user.setTime(LocalTime.now());

        return Response.success(user);
    }



//    @PostMapping("/test")
//    @ApiOperationLog(description = "测试接口")
//    public User test(@RequestBody User user) {
//        // 返参
//        return user;
    /*    } */


}
