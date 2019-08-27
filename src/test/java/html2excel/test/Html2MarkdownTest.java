package html2excel.test;

import org.junit.Test;

import my.html2file.html2excel.service.Html2ExcelService;
import my.html2file.html2markdown.service.Html2MarkdownService;

/**
 * html转excel测试
 *
 * @author 欧阳洁
 * @since 2018-03-29 17:40
 */
public class Html2MarkdownTest {
    @Test
    public void html2markdown() throws Exception {
        Html2ExcelService html2MarkdownService = new Html2ExcelService();//未引入spring，手动实例化
        html2MarkdownService.excute("http://www.jjwxc.net/bookbase_slave.php?booktype=free");
    }
}
