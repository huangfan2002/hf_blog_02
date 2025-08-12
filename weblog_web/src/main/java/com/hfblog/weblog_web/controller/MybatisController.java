package com.hfblog.weblog_web.controller;

import com.hfblog.weblog.common.domain.mapper.UserMapper;
import com.hfblog.weblog.common.domain.dos.UserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/insert")
    public String insertUser() {
        UserDo userDO = UserDo.builder()
                .username("d11")
                .password("114514")
                .createTime(new Date())
                .updateTime(new Date())
                .isDeleted(false)
                .build();

        int result = userMapper.insert(userDO);
        return "插入成功，主键ID为：" + userDO.getId();
    }
}
