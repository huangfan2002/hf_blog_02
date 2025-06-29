package com.hfblog.weblog.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: hf
 * @description: JSON 工具类
 **/
@Slf4j
public class JsonUtil {

    private static final ObjectMapper INSTANCE = new ObjectMapper();

    public static String toJsonString(Object obj) {
        try {
            return INSTANCE.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return obj.toString();
        }
    }
}

//上面的代码中，我们使用了 Spring Boot 内置的 JSON 工具Jackson ，
//同时，创建了一个静态的 ObjectMapper 类，并写个一个 toJsonString 方法，
//用于将传入的对象打印成 JSON 字符串。