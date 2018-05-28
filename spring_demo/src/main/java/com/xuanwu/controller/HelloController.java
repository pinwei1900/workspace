/*
 * Copyright (c) 2018年05月28日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package com.xuanwu.controller;

import com.xuanwu.bean.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description EnableConfigurationProperties 表示开启配置属性类
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/28
 * @Version 1.0.0
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class HelloController {

    @Autowired
    ConfigBean configBean;

    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private int age;

    @RequestMapping(value = "/name")
    public String name() {
        return "hello " + name + ", my age is " + age;
    }

    @RequestMapping(value = "/hello")
    public String index() {
        return "hello spring boot";
    }

    @RequestMapping(value = "/lucy")
    public String miya() {
        return configBean.toString();
    }
}
