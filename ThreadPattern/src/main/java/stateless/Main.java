/*
 * Copyright (c) 2018年08月08日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package stateless;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/8/8
 * @Version 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Gate gate = new Gate();
        new Persion("hao", "songlin", gate).start();
        new Persion("ming", "dao", gate).start();
    }
}
