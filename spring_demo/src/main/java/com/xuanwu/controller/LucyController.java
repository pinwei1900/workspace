/*
 * Copyright (c) 2018年05月28日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package com.xuanwu.controller;

import com.xuanwu.bean.ConfigBean;
import com.xuanwu.bean.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/28
 * @Version 1.0.0
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class, TestUser.class})
public class LucyController {

    @Autowired
    ConfigBean configBean;
    @Autowired
    TestUser testUser;

    @RequestMapping(value = "/lucy2")
    public String miya() {
        return configBean.toString();
    }

    @RequestMapping(value = "/user2")
    public String user() {
        return testUser.toString();
    }
}
