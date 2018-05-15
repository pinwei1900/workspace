package utils;

import static org.junit.Assert.assertEquals;

import db.DbProcess;
import entry.TableInfo;
import java.sql.SQLException;
import org.junit.Test;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/15
 * @Version 1.0.0
 */
public class UtilsTest {

    @Test
    public void UpcaseFirstLetter() {
        String result = Utils.UpcaseFirstLetter("lot_audit");

        assertEquals("LotAudit",result);
    }

    @Test
    public void convertToCamel() {
        String result = Utils.convertToCamel("lot_audit");

        assertEquals("lotAudit",result);
    }

    @Test
    public void queryField() throws SQLException {
        Utils.queryField("lot_audit", TableInfo.class);
    }

}
