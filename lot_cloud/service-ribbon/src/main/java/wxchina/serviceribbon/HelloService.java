/*
 * Copyright (c) 2018年04月19日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package wxchina.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/19
 * @Version 1.0.0
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class); //模板可能是通过装配生成的
    }
}
