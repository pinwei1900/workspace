/*
 * Copyright (c) 2018年05月15日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package utils;

import db.ConnTools;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/15
 * @Version 1.0.0
 */
public class Utils {

    /**
     * lot_case -> LotCase
     */
    public static String UpcaseFirstLetter(String str) {
        return Arrays.asList(str.split("_")).stream()
                .map(String::toLowerCase)
                .map(e -> e.substring(0, 1).toUpperCase() + e.substring(1)).reduce((a, b) -> a + b)
                .get();
    }


    /**
     * lot_case -> lotCase
     */
    public static String convertToCamel(String str) {
        int index = str.indexOf("_");
        String first = str.substring(0, index);
        String last = str.substring(index + 1);

        char[] cs = first.toCharArray();
        cs[0] = Character.toLowerCase(cs[0]);
        first = String.valueOf(cs);

        return first + UpcaseFirstLetter(last);
    }


    public static Object queryField(String name, Class T) throws SQLException {
        Connection conn = ConnTools.makeConnection();
        QueryRunner qRunner = new QueryRunner();
        return qRunner.query(conn, "show full columns from " + name, new BeanListHandler(T));
    }

}
