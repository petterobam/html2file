package my.html2file.html2html.service;

import my.html2file.utils.BaseUtils;
import my.html2file.utils.FilesUtils;
import my.html2file.utils.PathUtils;
import org.springframework.stereotype.Service;

/**
 * 将html页面转储为html页面
 *
 * @author 欧阳洁
 * @since 2018-04-17 16:56
 */
@Service
public class Html2HtmlService {
    /**
     * 转储HTML字符串为HTML页面
     *
     * @param pageHtmlContent
     * @return
     */
    public String excute(String pageHtmlContent) throws Exception {
        String outputPath = new StringBuffer("/output/").append(BaseUtils.getDateStr("yyyyMMdd")).append("/html/").append(BaseUtils.uuid2()).append(".html").toString();
        String absoultOutputPath = PathUtils.getClassRootPath(outputPath);
        FilesUtils.checkFolderAndCreate(absoultOutputPath);
        FilesUtils.newFile(absoultOutputPath,pageHtmlContent,"UTF-8");
        return outputPath;
    }
}
