/*
 * Copyright (c) 2018年05月15日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */

import entry.TableEntry;
import freemarker.template.TemplateException;
import generator.Generator;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/15
 * @Version 1.0.0
 */
public class Main {

    public static void main(String[] args) throws SQLException, IOException, TemplateException {
        String targetName = "lot_audit";
        TableEntry table = new TableEntry(targetName);

        Properties p = System.getProperties();

        //之类不能设置，因为系统信息还有很多，会导致系统信息失效
        Properties pps = new Properties();
        pps.load(new FileInputStream("src\\main\\resources\\application.properties"));
        System.setProperties(pps);
        

        Generator.generator(table);

    }
}
