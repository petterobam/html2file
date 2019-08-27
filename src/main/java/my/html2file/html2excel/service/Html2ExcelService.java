package my.html2file.html2excel.service;

import java.io.FileOutputStream;
import java.net.URL;

import org.springframework.stereotype.Service;

import my.html2file.html2excel.utils.TableToXls;
import my.html2file.html2markdown.utils.HTML2Md;
import my.html2file.utils.BaseUtils;
import my.html2file.utils.FilesUtils;
import my.html2file.utils.PathUtils;

/**
 * html转excel文件
 *
 * @author 欧阳洁
 * @since 2018-03-29 16:27
 */
@Service
public class Html2ExcelService {
    /**
     * 解析生成markdown
     *
     * @param pageUrl
     * @return
     */
    public String excute(String pageUrl) throws Exception {
        String outputPath = new StringBuffer("/output/").append(BaseUtils.getDateStr("yyyyMMdd")).append("/excel/").append(BaseUtils.uuid2()).append(".xls").toString();
        URL url = new URL(pageUrl);
        String absoultOutputPath = PathUtils.getClassRootPath(outputPath);
        FilesUtils.checkFolderAndCreate(absoultOutputPath);
        FileOutputStream fout = new FileOutputStream(absoultOutputPath);
        TableToXls.process(url, 30000, fout);
        fout.close();
        return outputPath;
    }
}
