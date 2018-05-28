/*
 * Copyright (c) 2018年05月28日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package com.xuanwu.dao;

import com.xuanwu.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/28
 * @Version 1.0.0
 */
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
