/*
 * Copyright (c) 2018年05月17日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/17
 * @Version 1.0.0
 */
public class Configuration {

    static Properties prop = new Properties();

    public static void init(String path) throws IOException {
        System.getProperties().load(new FileInputStream("src/main/resources/application.properties"));
        prop.load(new FileInputStream(path));
    }

    public static Object getValue(String key) {
        return prop.get(key);
    }

    public static void setValue(String key, Object value) {
        prop.put(key, value);
    }
}
