/*
 * Copyright (c) 2018年05月28日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package com.xuanwu.controller;

import com.xuanwu.bean.User;
import com.xuanwu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/28
 * @Version 1.0.0
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "根据用户名查询用户",notes = "查询")
    @GetMapping("/{username}")
    public String getUser(@PathVariable("username") String username) {
        User user = userService.findUserByName(username);
        return user.toString();
    }
}
