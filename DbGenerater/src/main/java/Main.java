/*
 * Copyright (c) 2018年05月15日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */


import config.Configuration;
import freemarker.template.TemplateException;
import generator.Generator;
import generator.combine.BeanCombine;
import generator.combine.DaoCombine;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/15
 * @Version 1.0.0
 */
public class Main {

    public static void main(String[] args) throws SQLException, IOException, TemplateException {

        Configuration.init("src/main/resources/typemap.properties");

        Generator.generator(new BeanCombine("lot_audit"), "Bean.ftl");
        Generator.generator(new DaoCombine("lot_audit"), "Bean.ftl");
    }
}
