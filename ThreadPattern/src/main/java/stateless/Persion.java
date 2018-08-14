/*
 * Copyright (c) 2018年08月08日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package stateless;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/8/8
 * @Version 1.0.0
 */
@AllArgsConstructor
@Getter
public class Persion extends Thread{
    String firstName;
    String lastName;
    Gate gate;

    @Override
    public void run() {
        while (true) {
            gate.pass(this);
        }
    }
}
