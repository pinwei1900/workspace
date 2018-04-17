/*
 * Copyright (c) 2018年04月17日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package handler;

import bean.DownFile;
import db.SqlHelper;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 当线程池中的所有线程都处于闲置状态时触发此任务
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/17
 * @Version 1.0.0
 */
public class TaskFinder extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(TaskFinder.class);

    private static ArrayBlockingQueue<DownFile> waitFile = new ArrayBlockingQueue<DownFile>(10000);
    private static SqlHelper helper;
    static {
        helper = new SqlHelper();
    }

    @Override
    public void run() {
        try {
            executor();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private synchronized static List<DownFile> getUnDownloadRecord() throws SQLException, ClassNotFoundException {
        List<DownFile> files = helper
                .executeQuery("SELECT * FROM fatch_down_file WHERE success = 0",
                        (rs, index) -> {
                            int id = rs.getInt(1);
                            String host = rs.getString(2);
                            String name = rs.getString(3);
                            String path = rs.getString(4);
                            int success = rs.getInt(5);
                            return new DownFile(id, host, name, path, success);
                        });
        return files;
    }

    public static boolean checkFinished(){
        try {
            return getUnDownloadRecord().size() == 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void executor() throws SQLException, ClassNotFoundException {
        List<DownFile> files = getUnDownloadRecord();

        if (files.size() == 0) {
            return;
        }

        try {
            for (DownFile file : files) {
                if (file.getSuccess() == 0) {
                    waitFile.put(file);
                }
            }
        } catch (InterruptedException e) {
            logger.error("put file to ArrayBlockingQueue error", e);
        }

    }

    public static DownFile getTask() {
        return waitFile.poll();
    }


    public static void addTask(DownFile failedTask) throws InterruptedException {
        waitFile.put(failedTask);
    }
}