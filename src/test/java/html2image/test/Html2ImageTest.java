package html2image.test;

import my.html2file.html2image.service.Html2ImageService;
import org.junit.Test;

/**
 * html转image测试
 *
 * @author 欧阳洁
 * @since 2018-03-28 15:35
 */
public class Html2ImageTest {
    @Test
    public void html2iImage() throws Exception {
        Html2ImageService html2ImageService = new Html2ImageService();//未引入spring，手动实例化
        html2ImageService.excute("https://wkhtmltopdf.org");
    }
}
