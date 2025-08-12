package com.hfblog.weblog.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.hfblog.weblog.common.domain.mapper")
public class MybatisPlusConfig {
}