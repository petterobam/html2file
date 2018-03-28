package my.api.entity;

public class MyAjaxPost {
    public static final String TO_IMG = "1";
    public static final String TO_PDF = "2";
    /**
     * 目标链接
     */
    private String htmlUrl;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 文件类型
     */
    private String fileExt;



    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
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
}
