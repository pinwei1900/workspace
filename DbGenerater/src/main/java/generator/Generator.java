/*
 * Copyright (c) 2018年05月15日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import generator.combine.Combine;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/15
 * @Version 1.0.0
 */
public class Generator {

    private static Configuration cfg;

    static {
        try {
            cfg = new Configuration(Configuration.VERSION_2_3_22);
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templete/"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generator(Combine combine ,String templete)
            throws IOException, TemplateException, SQLException {
        Map<String, Object> root = setBaseTempleteInfo(combine);
        Template temp = cfg.getTemplate(templete);

        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
    }

    private static Map<String, Object > setBaseTempleteInfo(Combine combine) {
        Map<String, Object> map = combine.combine();
        map.put("mail", "mailto:haosonglin@wxchina.com");
        map.put("author", "songlin.Hao");
        map.put("name", "");
        map.put("field", "");
        map.put("date", new Date().toString());
        return map;
    }
}
