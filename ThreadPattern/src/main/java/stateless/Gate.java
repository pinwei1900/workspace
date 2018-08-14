/*
 * Copyright (c) 2018年08月08日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package stateless;

import lombok.Setter;
import util.Utils;

/**
 * @Description Immutable和无状态非常相似，
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/8/8
 * @Version 1.0.0
 */
@Setter
public class Gate {

    void pass(Persion p) {
        String first = p.getFirstName();
        Utils.sleep(1000);
        String last = p.getLastName();
        System.out.println(first + " " + last + "正在通过一扇门");
    }
}
