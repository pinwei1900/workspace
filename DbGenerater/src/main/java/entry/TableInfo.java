/*
 * Copyright (c) 2018年05月15日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package entry;

import lombok.Data;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/15
 * @Version 1.0.0
 */
@Data
public class TableInfo {
    String Filed;
    String Type;
    String Collation;
    String Null;
    String Key;
    String Default;
    String Extra;
    String Privileges;
    String Comment;
}
