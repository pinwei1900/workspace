/*
 * Copyright (c) 2018年06月08日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package fdasdfads;

import java.lang.reflect.Constructor;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/6/8
 * @Version 1.0.0
 */
public class AnnotationProcessor {

    public static void init(Object object) {
        if (!(object instanceof User)) {
            throw new IllegalArgumentException();
        }

        Constructor[] constructors = object.getClass().getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            if (constructor.isAnnotationPresent(UserMeta.class)) {
                UserMeta userFill = (UserMeta) constructor.getAnnotation(UserMeta.class);
                int age = userFill.age();
                int id = userFill.id();
                String name = userFill.name();
                ((User) object).setAge(age);
                ((User) object).setId(id);
                ((User) object).setName(name);
            }
        }
    }

}
