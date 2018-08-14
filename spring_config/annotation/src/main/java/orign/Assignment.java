package orign;/*
 * Copyright (c) 2018年06月08日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/6/8
 * @Version 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Assignment {

    String assignee();

    int effort();

    double finished() default 0;
}
