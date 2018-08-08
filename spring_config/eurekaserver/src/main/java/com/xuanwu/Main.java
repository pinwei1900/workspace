/*
 * Copyright (c) 2018年06月05日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package com.xuanwu;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/6/5
 * @Version 1.0.0
 */
public class Main {

    static boolean a;
    static byte b;
    static char c;
    static short c1;
    static int d;
    static long e;
    static float f;
    static double g;



    public static void main(String[] args) {
        new Main().print(a);
        new Main().print(b);
        new Main().print(c);
        new Main().print(c1);
        new Main().print(d);
        new Main().print(e);
        new Main().print(f);
        new Main().print(g);

    }

    private void print(Object object) {
        System.out.println(object.getClass().getName() + ":" + object);
    }

}
