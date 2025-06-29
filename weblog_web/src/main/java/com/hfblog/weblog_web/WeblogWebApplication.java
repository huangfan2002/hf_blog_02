package com.hfblog.weblog_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// 多模块项目中，必需手动指定扫描 com.hf_blog.weblog 包下面的所有类
@SpringBootApplication
@ComponentScan({"com.hfblog.weblog.*"})
@ComponentScan({"com.hfblog.weblog_web.*"})
public class WeblogWebApplication {
//11111
    public static void main(String[] args) {
        SpringApplication.run(WeblogWebApplication.class, args);
    }

}


