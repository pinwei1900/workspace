/*
 * Copyright (c) 2018年05月17日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package generator.combine;

import config.Configuration;
import entry.TableEntry;
import entry.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description Bean是其中最简单的生产对象，
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/17
 * @Version 1.0.0
 */
public class BeanCombine extends Combine {


    public BeanCombine(String tableName) throws SQLException {
        super(new TableEntry(tableName));
    }

    @Override
    public Map<String, Object> combine() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("filename", getTabel().getName());
        map.put("fields", convert(getTabel().getTableFiled()));
        return map;
    }

    private List<String> convert(List<TableInfo> tableInfos) {
        List<String> res = new ArrayList<>();
        for (TableInfo info : tableInfos) {
            String type = (String) Configuration.getValue(info.getType());
            if (type == null) {
                try {
                    throw new Exception("not found type in typemap.properties:" + info.getType());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            res.add(type + " " + info.getField() + "    //" + info.getComment());
        }
        return res;
    }
}
