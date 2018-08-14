/*
 * Copyright (c) 2018年08月13日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package com.neo.service;

import com.neo.service.base.BaseService;
import com.neo.entity.UserEntity;
import com.neo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 具体的实现类，
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/8/13
 * @Version 1.0.0
 */
@Service
public class UserService extends BaseService<UserEntity> implements UserMapper{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(UserEntity user) {
        userMapper.insert(user);
    }

    @Override
    public void update(UserEntity obj) {
        userMapper.update(obj);
    }
}
