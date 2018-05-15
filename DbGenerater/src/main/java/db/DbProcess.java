/*
 * Copyright (c) 2018年05月15日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package db;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/15
 * @Version 1.0.0
 */
public class DbProcess {

    public static Object queryField(String name, Class T) throws SQLException {
        Connection conn = ConnTools.makeConnection();
        QueryRunner qRunner = new QueryRunner();
        return qRunner.query(conn, "show full columns from " + name, new BeanListHandler(T));
    }
}
