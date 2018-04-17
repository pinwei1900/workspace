/*
 * Copyright (c) 2018年04月17日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package handler;

import bean.DownFile;
import db.SqlHelper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.FtpHelper;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/17
 * @Version 1.0.0
 */
public class FatchLoader extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(FatchLoader.class);
    private final int threadNumber;

    private String path;
    private FtpHelper ftpHelper;

    public FatchLoader(String savepath ,int thread_number ) throws IOException {
        this.path = savepath;
        this.threadNumber = thread_number;
        this.ftpHelper = new FtpHelper(path);
    }

    @Override
    public void run() {
        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(threadNumber);
        while (true) {
            DownFile task;
            try {
                task = TaskFinder.getTask();
                cachedThreadPool.execute(new TaskRunner(task));
            } catch (InterruptedException e) {
                logger.error("get task error", e);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e.printStackTrace();
                }
            }
        }
    }

    class TaskRunner implements Runnable {

        private final DownFile task;

        public TaskRunner(DownFile task) {
            this.task = task;
        }

        @Override
        public void run() {
            try {
                boolean success = ftpHelper.download(task);
                SqlHelper sqlHelper = new SqlHelper();
                if (success) {
                    sqlHelper.executeUpdate(
                            "UPDATE fatch_down_file SET success = 1 WHERE id = " + task
                                    .getId() + ";");
                    logger.info("task : {} download over , name = {}", task.getId(),
                            task.getName());
                } else {
                    TaskFinder.addTask(task);
                }
            } catch (ClassNotFoundException e) {
                logger.error("jdbc:sqlite no dound ");
            } catch (InterruptedException e) {
                logger.error("add task failed ，", e);
            } catch (SQLException e) {
                logger.error("sql executor error ，", e);
            }

        }
    }
}
