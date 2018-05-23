/*
 * Copyright (c) 2018年05月17日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package bean;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/17
 * @Version 1.0.0
 */
public class FieldType {

    String type;
    String field;

    public FieldType(String type, String field) {
        this.type = type;
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
