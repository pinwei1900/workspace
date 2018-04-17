/*
 * Copyright (c) 2018年04月17日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package config;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/17
 * @Version 1.0.0
 */
public class constant {

    public static final String dbsql = "create table fatch_down_file\n"
            + "(\n"
            + "\tid INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + "\thost CHARACTER(100) not null,\n"
            + "\tname CHARACTER(100),\n"
            + "\tpath CHARACTER(100),\n"
            + "\tsuccess BOOLEAN not null\n"
            + ")\n"
            + ";\n"
            + "\n"
            + "create unique index table_name_id_uindex\n"
            + "\ton fatch_down_file (id)\n"
            + ";\n"
            + "\n";

    public static final String PATH_Prefix = "E:/Download/";

    public static final String host = "ftp.ncbi.nlm.nih.gov";
    public static final String downloadSummary = "download_assembly_summary.txt";
    public static final String dbFilePath = "fatch_web_file.db";


}
