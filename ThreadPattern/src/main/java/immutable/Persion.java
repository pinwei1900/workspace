/*
 * Copyright (c) 2018年08月08日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package immutable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 如果所有的值都成了不可改变，那么这个类就不害怕多线程中的并发操作
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/8/8
 * @Version 1.0.0
 */
@AllArgsConstructor
@Getter
public class Persion extends Thread{
    final String firstName;
    final String lastName;
    final Gate gate;

    @Override
    public void run() {
        while (true) {
            gate.pass(this);
        }
    }
}
