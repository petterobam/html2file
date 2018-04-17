package my.html2file.html2image.service;

import my.html2file.utils.BaseUtils;
import my.html2file.utils.CmdUtils;
import my.html2file.utils.FilesUtils;
import my.html2file.utils.OsInfo;
import my.html2file.utils.PathUtils;
import org.springframework.stereotype.Service;

/**
 * html页面转image的服务
 *
 * @author 欧阳洁
 * @since 2018-03-28 11:50
 */
@Service
public class Html2ImageService {
    /**
     * windows执行文件
     */
    private String windowExePath;
    /**
     * linux执行文件
     */
    private String linuxExePath;

    /**
     * 解析生成image
     *
     * @param pageUrl
     * @return
     */
    public String excute(String pageUrl) throws Exception {
        return excute(pageUrl,null);
    }

    /**
     * 解析生成image
     *
     * @param pageUrl
     * @return
     */
    public String excute(String pageUrl,String picType) throws Exception {
        if(BaseUtils.isBlank(picType)){
            picType = ".png";
        }
        String outputPath = new StringBuffer("/output/").append(BaseUtils.getDateStr("yyyyMMdd")).append("/image/").append(BaseUtils.uuid2()).append(picType).toString();

        String cmdStr = getCmdStr(pageUrl, outputPath);
        boolean success = CmdUtils.excute(cmdStr);
        if (success) {
            return outputPath;
        } else {
            throw new Exception("转化异常！");
        }
    }

    /**
     * 根据操作系统类别，获取不同的cmd字符串
     *
     * @param pageUrl
     * @param outputPath
     * @return
     */
    private String getCmdStr(String pageUrl, String outputPath) {
        StringBuilder cmdStr = new StringBuilder();
        String absoultOutputPath = PathUtils.getClassRootPath(outputPath);
        /************************输出文件夹检查************************/
        FilesUtils.checkFolderAndCreate(absoultOutputPath);
        String absoultExePath = "";
        if (OsInfo.isWindows()) {//windows系统
            absoultExePath = getWindowExePath();
            absoultOutputPath = PathUtils.getWindowsRightPath(absoultOutputPath);
        } else {//默认linux系统
            absoultExePath = getLinuxExePath();
            //需要给脚本授权
            //cmdStr.append("chmod +x ").append(absoultExePath).append(" && ");
            CmdUtils.excute("chmod +x " + absoultExePath);
        }
        cmdStr.append(absoultExePath).append(" ").append(pageUrl).append(" ").append(absoultOutputPath);
        return cmdStr.toString();
    }

    public String getWindowExePath() {
        if (BaseUtils.isBlank(this.windowExePath)) {
            String absoultExePath = PathUtils.getClassRootPath("/plugin/window/wkhtmltopdf/bin/wkhtmltoimage");
            this.windowExePath = PathUtils.getWindowsRightPath(absoultExePath);
        }
        return this.windowExePath;
    }

    public void setWindowExePath(String windowExePath) {
        this.windowExePath = windowExePath;
    }

    public String getLinuxExePath() {
        if (BaseUtils.isBlank(this.linuxExePath)) {
            this.linuxExePath = PathUtils.getClassRootPath("/plugin/linux/wkhtmltox/bin/wkhtmltoimage");
        }
        return this.linuxExePath;
    }

    public void setLinuxExePath(String linuxExePath) {
        this.linuxExePath = linuxExePath;
    }
}
