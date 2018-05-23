/*
 * Copyright (c) 2018年05月17日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package generator.combine;

import entry.TableEntry;
import java.util.Map;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/17
 * @Version 1.0.0
 */
public abstract class Combine {

    private TableEntry table;

    Combine(TableEntry table) {
        this.table = table;
    }

    public abstract Map<String, Object> combine();

    protected TableEntry getTabel() {
        return table;
    }
}
