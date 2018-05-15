/*
 * Copyright (c) 2018年05月15日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package entry;

import java.sql.SQLException;
import java.util.List;
import lombok.Data;
import utils.Utils;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/15
 * @Version 1.0.0
 */
@Data
public class TableEntry {
    public TableEntry(String tableName) throws SQLException {
        this.tableName = tableName;
        String name = Utils.UpcaseFirstLetter(tableName);
        this.beanName = name + ".java";
        this.daoName = name + "Dao.java";
        this.serviceName = name + "Service.java";
        this.controllerName = name + "Controller.java";
        this.mapperName = name + "Mapper.xml";
        this.tableFiled = (List<TableInfo>) Utils.queryField(tableName, TableInfo.class);
    }
    String tableName;
    String beanName;
    String mapperName;
    String daoName;
    String serviceName;
    String controllerName;
    List<TableInfo> tableFiled;
}
