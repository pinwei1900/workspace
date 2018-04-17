/*
 * Copyright (c) 2018年04月17日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */

import handler.FatchLoader;
import handler.TaskFinder;
import handler.TaskManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/17
 * @Version 1.0.0
 */
public class Main {

    public static void main(String[] args)
            throws SQLException, ClassNotFoundException, IOException, InterruptedException {

        InputStream in = new FileInputStream("src/main/resources/config.properties");
        Properties p = new Properties();
        p.load(in);

        TaskManager.initDb(p.getProperty("PATH_Prefix") ,p.getProperty("downloadSummary"));

        TaskFinder finder = new TaskFinder();
        finder.start();

        FatchLoader loader = new FatchLoader(p.getProperty("PATH_Prefix"),Integer.valueOf(p.getProperty("thread_number")));
        loader.start();
    }
}
