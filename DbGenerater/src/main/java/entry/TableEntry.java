/*
 * Copyright (c) 2018年05月15日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package entry;

import java.sql.SQLException;
import java.util.List;
import utils.Utils;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/15
 * @Version 1.0.0
 */

public class TableEntry {

    public TableEntry(String tableName) throws SQLException {
        this.tableName = tableName;
        this.name = Utils.UpcaseFirstLetter(tableName);
        this.beanName = name + ".java";
        this.mapperName = name + "Mapper.xml";
        this.daoName = name + "Dao.java";
        this.serviceName = name + "Service.java";
        this.controllerName = name + "Controller.java";
        this.tableFiled = (List<TableInfo>) Utils.queryField(tableName, TableInfo.class);
    }

    String name;
    String tableName;
    String beanName;
    String mapperName;
    String daoName;
    String serviceName;
    String controllerName;
    List<TableInfo> tableFiled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TableInfo> getTableFiled() {
        return tableFiled;
    }

    public void setTableFiled(List<TableInfo> tableFiled) {
        this.tableFiled = tableFiled;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getMapperName() {
        return mapperName;
    }

    public void setMapperName(String mapperName) {
        this.mapperName = mapperName;
    }

    public String getDaoName() {
        return daoName;
    }

    public void setDaoName(String daoName) {
        this.daoName = daoName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }
}
