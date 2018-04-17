/*
 * Copyright (c) 2018年04月17日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */

import handler.FatchLoader;
import handler.TaskFinder;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/17
 * @Version 1.0.0
 */
public class Main {

    public static void main(String[] args)
            throws SQLException, ClassNotFoundException, IOException, InterruptedException {
        TaskFinder finder = new TaskFinder();
        finder.start();

        FatchLoader loader = new FatchLoader();
        loader.start();
    }
}
