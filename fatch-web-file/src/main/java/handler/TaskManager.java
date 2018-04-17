/*
 * Copyright (c) 2018年04月17日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package handler;

import static config.constant.dbFilePath;
import static config.constant.dbsql;

import db.SqlHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import util.FtpHelper;

/**
 * @Description store all url in download_assembly_summary.txt to database
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/17
 * @Version 1.0.0
 */
public class TaskManager {

    static SqlHelper sqlHelper;

    static {
        try {
            File file = new File(dbFilePath);
            if (!file.exists()) {
                Class.forName("org.sqlite.JDBC");
                DriverManager.getConnection("jdbc:sqlite:" + dbFilePath);
                new SqlHelper().executeUpdate(dbsql);
            }
            sqlHelper = new SqlHelper();
            sqlHelper.executeUpdate("DELETE FROM fatch_down_file;");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getAllfilepath(String path) throws IOException {
        List<String> filePaths = new ArrayList<>();
        Files.lines(new File(path).toPath()).map(String::trim).forEach(filePaths::add);
        return filePaths;
    }

    public static void initDb(String downloadSummary) {
        try {
            List<String> files = getAllfilepath(downloadSummary);
            List<String> execList = new ArrayList<>();

            for (String path : files) {
                URL url = new URL(path);
                String host = url.getHost();
                String name = FtpHelper.getPathSuffix(path);
                int success = 0;
                if (checkFileExist(path)) {
                    success = 1;
                }
                execList.add(
                        "INSERT INTO fatch_down_file (host, name, path, success) VALUES ('" + host
                                + "','" + name + "','" + url.getFile() + "'," + success + ");");
            }
            sqlHelper.executeUpdate(execList);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkFileExist(String link) {
        return new File(FtpHelper.getSavePath(link)).exists();
    }

    public static void main(String[] args) {

    }
}
