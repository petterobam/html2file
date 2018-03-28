package html2pdf.test;

import my.html2pdf.service.Html2PdfService;
import org.junit.Test;

/**
 * html转PDF测试
 *
 * @author 欧阳洁
 * @since 2018-03-28 15:35
 */
public class Html2PdfTest {
    @Test
    public void html2pdf() throws Exception {
        Html2PdfService html2PdfService = new Html2PdfService();//未引入spring，手动实例化
        html2PdfService.excute("https://wkhtmltopdf.org");
    }
}
