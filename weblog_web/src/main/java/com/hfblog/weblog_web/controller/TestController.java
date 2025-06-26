package com.hfblog.weblog_web.controller;



import com.hfblog.weblog_web.model.User;
import com.hf_blog.weblog.common.aspect.ApiOperationLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class TestController {

    @GetMapping("/")
    public String index() {
        return "服务已启动，欢迎使用 Weblog 博客系统！";
    }



    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public User test(@RequestBody User user) {
        // 返参
        return user;
    }

}
