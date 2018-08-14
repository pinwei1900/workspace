/*
 * Copyright (c) 2018年06月08日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package fdasdfads;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/6/8
 * @Version 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        User user = new User();
        AnnotationProcessor.init(user);
        System.out.println(user.toString());
    }
}
