package my.html2file.html2markdown.service;

import my.html2file.utils.BaseUtils;
import my.html2file.utils.FilesUtils;
import my.html2file.utils.PathUtils;
import my.html2file.html2markdown.utils.HTML2Md;
import org.springframework.stereotype.Service;

import java.net.URL;

/**
 * html转markdown文件
 *
 * @author 欧阳洁
 * @since 2018-03-29 16:27
 */
@Service
public class Html2MarkdownService {
    /**
     * 解析生成markdown
     *
     * @param pageUrl
     * @return
     */
    public String excute(String pageUrl) throws Exception {
        String outputPath = new StringBuffer("/output/").append(BaseUtils.getDateStr("yyyyMMdd")).append("/markdown/").append(BaseUtils.uuid2()).append(".md").toString();
        URL url = new URL(pageUrl);
        String markdownStr = HTML2Md.convert(url, 30000);
        String absoultOutputPath = PathUtils.getClassRootPath(outputPath);
        FilesUtils.checkFolderAndCreate(absoultOutputPath);
        FilesUtils.newFile(absoultOutputPath,markdownStr,"UTF-8");
        return outputPath;
    }
}
