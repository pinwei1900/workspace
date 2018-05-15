package utils;

import entry.TableEntry;
import freemarker.template.TemplateException;
import generator.Generator;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.Test;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/5/15
 * @Version 1.0.0
 */
public class GeneratorTest {

    @Test
    public void UpcaseFirstLetter() throws IOException, TemplateException, SQLException {
        TableEntry table = new TableEntry("lot_audit");
        Generator.generator(table);
    }
}
