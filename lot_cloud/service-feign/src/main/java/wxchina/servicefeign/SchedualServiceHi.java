/*
 * Copyright (c) 2018年04月19日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package wxchina.servicefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/19
 * @Version 1.0.0
 */
@FeignClient(value = "service-hi")  //指定调用的的服务
public interface SchedualServiceHi {

    //调用的接口
    @RequestMapping(value = "hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
