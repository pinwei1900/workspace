/*
 * Copyright (c) 2018年04月17日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/17
 * @Version 1.0.0
 */
public class SqliteTest {

    static final String dbFilePath = "test.db";
    static final String dbsql = "create table t1 (id integer , x integer , y integer, weight integer);";


    static final String sql = "insert into t1 values (?,?,?,?);";

    static final int test_number = 1000000;

    static File dbFile;
    static Connection conn;
    @Before
    public void createDb(){
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFilePath);
            conn.setAutoCommit(false);
            dbFile = new File(dbFilePath);

            Statement stat = conn.createStatement();
            stat.executeUpdate(dbsql);
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertNormalTest() throws SQLException {
        long start = System.currentTimeMillis();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for (int i = 0 ; i < test_number ; i++) {
            pstmt.setInt(1, i);
            pstmt.setInt(2, i * 2);
            pstmt.setInt(3, i / 2);
            pstmt.setInt(4, i * i);
            pstmt.executeUpdate();
        }
        conn.commit();
        System.out.println(System.currentTimeMillis() - start);
    }


    @Test
    public void insertNotPreTest() throws SQLException {
        long start = System.currentTimeMillis();
        Statement pstmt = conn.createStatement();
        for (int i = 0 ; i < test_number ; i++) {
            pstmt.executeUpdate("insert into t1 values ("+i+","+i*2+","+i/2+","+i*i+");");
        }
        conn.commit();
        System.out.println(System.currentTimeMillis() - start);
    }


    @Test
    public void insertTransTest() throws SQLException {
        long start = System.currentTimeMillis();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for (int i = 0 ; i < test_number ; i++) {
            pstmt.setInt(1, i);
            pstmt.setInt(2, i * 2);
            pstmt.setInt(3, i / 2);
            pstmt.setInt(4, i * i);
            pstmt.addBatch();
        }
        pstmt.executeBatch();
        conn.commit();
        System.out.println(System.currentTimeMillis() - start);
    }

    @After
    public void deleteDb() throws SQLException {
        Statement stat = conn.createStatement();
        stat.executeUpdate("DROP TABLE t1;");
        conn.commit();
        if (conn != null) {
            conn.close();
        }
    }
}
