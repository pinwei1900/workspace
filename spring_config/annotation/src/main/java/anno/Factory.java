/*
 * Copyright (c) 2018年06月08日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package anno;

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

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface Factory {

    //工厂的名字
    Class type();

    //用来表示生成哪个对象的唯一id
    String id();
}
