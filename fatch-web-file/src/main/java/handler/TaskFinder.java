/*
 * Copyright (c) 2018年04月17日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package handler;

import bean.DownFile;
import db.SqlHelper;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 当线程池中的所有线程都处于闲置状态时触发此任务
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/17
 * @Version 1.0.0
 */
public class TaskFinder {

    private static final Logger logger = LoggerFactory.getLogger(TaskFinder.class);

    private static LinkedBlockingQueue<DownFile> waitFile = new LinkedBlockingQueue<>();

    private static SqlHelper helper;

    static {
        helper = new SqlHelper();
    }

    private synchronized static List<DownFile> getUnDownloadRecord(int limit) {
        try {
            String sql = "SELECT * FROM fatch_down_file WHERE success = 0";
            if (limit != 0) {
                sql += " limit " + limit;
            }

            return helper.executeQuery(sql,
                    (rs, index) -> {
                        int id = rs.getInt(1);
                        String host = rs.getString(2);
                        String name = rs.getString(3);
                        String path = rs.getString(4);
                        int success = rs.getInt(5);
                        return new DownFile(id, host, name, path, success);
                    });
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("查看任务出错：");
            e.printStackTrace();
        }
        return Collections.emptyList();
    }



    static DownFile getTask() throws InterruptedException {
        if (waitFile.size() == 0) {
            List<DownFile> files = getUnDownloadRecord(1000);
            for (DownFile file : files) {
                waitFile.put(file);
            }
        }
        return waitFile.poll();
    }


    static void addTask(DownFile failedTask) throws InterruptedException {
        waitFile.put(failedTask);
    }
}
