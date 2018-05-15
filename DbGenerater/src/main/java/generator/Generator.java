/*
 * Copyright (c) 2018年05月15日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package generator;

import entry.TableEntry;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/15
 * @Version 1.0.0
 */
public class Generator {

    private static final Configuration cfg;

    static {
        cfg = new Configuration(Configuration.VERSION_2_3_22);
        try {
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templete/"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    public static void generator(TableEntry table) throws IOException, TemplateException {
        Map<String, Object> root = new HashMap<>();

        root.put("mail", "mailto:haosonglin@wxchina.com");
        root.put("author", "songlin.Hao");
        root.put("name", "");
        root.put("field", "");
        root.put("date", new Date().toString());

        Template temp = cfg.getTemplate("Bean.ftl");
        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
    }
}
