/*
 * Copyright (c) 2018年04月19日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package wxchina.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
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

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class); //模板可能是通过装配生成的
    }

    public String hiError(String name) {
        return "hi ," + name + ", server error!";
    }
}
