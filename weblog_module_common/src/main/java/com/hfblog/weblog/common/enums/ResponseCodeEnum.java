package com.hfblog.weblog.common.enums;

import com.hfblog.weblog.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

//自定义错误码枚举

//在上述代码中，我们定义了异常码和错误信息两个字段，并实现了 BaseExceptionInterface 接口，
// 同时，还定义了一个 SYSTEM_ERROR 枚举值，它属于系统通用异常，通常是未知的异常，
// 为了对调用者表示友好性，统一提示 出错啦，后台小哥正在努力修复中...。
//除了通用异常外就是业务异常了, 这里定义了一个供测试使用的 PRODUCT_NOT_FOUND 枚举值，
// 表示产品不存在，后面会演示如何使用。

@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    // ----------- 通用异常状态码 -----------
    SYSTEM_ERROR("10000", "出错啦，后台小哥正在努力修复中..."),

    // ----------- 业务异常状态码 -----------
    PRODUCT_NOT_FOUND("20000", "该产品不存在（测试使用）"),
    ;

    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;
}