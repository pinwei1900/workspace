/*
 * Copyright (c) 2018年08月08日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package guarded_suspension;

import lombok.Getter;
import lombok.Setter;
import util.Utils;

/**
 * @Description 所谓的资源竞争，应该注意的部分就是他们有状态的部分
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/8/8
 * @Version 1.0.0
 */
@Setter
@Getter
public class Gate {

    Boolean isopen = false;

    int times;

    boolean pass(Persion p) {
        if (!isopen) {
            return false;
        }
        Utils.sleep(1);
        times++;
        return true;
    }

    public Boolean isOpen() {
        return isopen;
    }

    public void open() {
        if (!isopen) {
            isopen = true;
        }
    }

    public void close() {
        if (isopen) {
            isopen = false;
        }
    }
}
