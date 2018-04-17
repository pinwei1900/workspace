/*
 * Copyright (c) 2018年04月17日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package bean;

import lombok.Data;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/17
 * @Version 1.0.0
 */
@Data
public class DownFile {
    private int id;
    private String host;
    private String name;
    private String path;
    private int success;

    public DownFile(int id, String host, String name, String path, int success) {
        this.id = id;
        this.host = host;
        this.name = name;
        this.path = path;
        this.success = success;
    }
}
