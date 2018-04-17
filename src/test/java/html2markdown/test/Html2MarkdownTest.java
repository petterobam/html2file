package html2markdown.test;

import my.html2file.html2markdown.service.Html2MarkdownService;
import org.junit.Test;

/**
 * html转markdown测试
 *
 * @author 欧阳洁
 * @since 2018-03-29 17:40
 */
public class Html2MarkdownTest {
    @Test
    public void html2markdown() throws Exception {
        Html2MarkdownService html2MarkdownService = new Html2MarkdownService();//未引入spring，手动实例化
        html2MarkdownService.excute("http://jsoup.org/");
    }
}
