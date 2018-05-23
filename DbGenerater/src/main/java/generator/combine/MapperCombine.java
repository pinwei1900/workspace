/*
 * Copyright (c) 2018年05月17日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package generator.combine;

import entry.TableEntry;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/17
 * @Version 1.0.0
 */
public class MapperCombine extends Combine {

    public MapperCombine(String tableName) throws SQLException {
        super(new TableEntry(tableName));
    }

    @Override
    public Map<String, Object> combine() {
        HashMap<String, Object> map = new HashMap<>();

        return map;
    }
}
