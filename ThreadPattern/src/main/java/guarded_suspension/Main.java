/*
 * Copyright (c) 2018年08月08日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package guarded_suspension;

import util.Utils;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/8/8
 * @Version 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        final Gate gate = new Gate();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    gate.open();
                    Utils.sleep(1);
                    gate.close();
                }
            }
        }).start();

        new Persion("A", "A", gate).start();
        new Persion("B", "B", gate).start();


    }
}
