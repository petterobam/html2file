package my.html2file.api.entity;

public class MyAjaxPost {
    public static final String TO_IMG = "1";
    public static final String TO_PDF = "2";
    public static final String TO_MD = "3";
    public static final String TO_WORD = "4";
    public static final String TO_EXCEL = "5";
    /**
     * 目标链接
     */
    private String pageUrl;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 文件类型
     */
    private String fileExt;
    /**
     * 目标页面Html内容
     */
    private String pageHtmlContent;


    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getPageHtmlContent() {
        return pageHtmlContent;
    }

    public void setPageHtmlContent(String pageHtmlContent) {
        this.pageHtmlContent = pageHtmlContent;
    }
}
