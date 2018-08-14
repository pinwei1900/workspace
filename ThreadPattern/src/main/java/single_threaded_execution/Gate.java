/*
 * Copyright (c) 2018年08月08日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package single_threaded_execution;

import lombok.Setter;
import util.Utils;

/**
 * @Description 所谓的资源竞争，应该注意的部分就是他们有状态的部分
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/8/8
 * @Version 1.0.0
 */
@Setter
public class Gate {

    Persion persion;

    synchronized void pass(Persion p) {
        setPersion(p);
        String first = persion.getFirstName();
        Utils.sleep(1000);
        String last = persion.getLastName();
        System.out.println(first + " " + last + "正在通过这个门");
    }
}
