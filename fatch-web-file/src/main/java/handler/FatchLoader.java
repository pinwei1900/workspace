/*
 * Copyright (c) 2018年04月17日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package handler;

import bean.DownFile;
import db.SqlHelper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
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

    private FtpHelper ftpHelper;

    public FatchLoader(String savepath ,int thread_number ) throws IOException {
        this.threadNumber = thread_number;
        this.ftpHelper = new FtpHelper(savepath);
    }

    @Override
    public void run() {
        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(threadNumber);
        while (true) {
            try {
                DownFile task = TaskFinder.getTask();
                if (task == null) {
                    if (TaskFinder.checkFinished()) {
                        break;
                    }
                    Thread.sleep(500);
                    continue;
                }
                cachedThreadPool.execute(new TaskRunner(task));
            } catch (Exception e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        cachedThreadPool.shutdown();
    }

    class TaskRunner implements Runnable {

        private final DownFile task;

        TaskRunner(DownFile task) {
            this.task = task;
        }

        @Override
        public void run() {
            try {
                boolean success = ftpHelper.download(task);
                if (success) {
                    new SqlHelper().executeUpdate(
                            "UPDATE fatch_down_file SET success = 1 WHERE id = " + task
                                    .getId() + ";");

                    logger.info("task : {} download over , name = {} , progress：{} , time = {}",
                            task.getId(),
                            task.getName(),TaskManager.updateAndProgress(),new Date());
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
