package com.hfblog.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hfblog.weblog.common.domain.dos.UserDo;


public interface UserMapper extends BaseMapper<UserDo> {
    default UserDo findByUsername(String username) {
        LambdaQueryWrapper<UserDo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDo::getUsername, username);
        return selectOne(wrapper);
    }
}