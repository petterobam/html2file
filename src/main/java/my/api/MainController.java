package my.api;

import my.api.entity.MyAjaxPost;
import my.api.entity.MyAjaxResult;
import my.html2image.service.Html2ImageService;
import my.html2markdown.service.Html2MarkdownService;
import my.html2pdf.service.Html2PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @Autowired
    private Html2ImageService html2ImageService;
    @Autowired
    private Html2PdfService html2PdfService;
    @Autowired
    private Html2MarkdownService html2MarkdownService;

    /**
     * html页面转图片
     *
     * @param pageUrl
     * @param fileExt
     * @return
     */
    @RequestMapping("/html2image")
    public String html2image(@RequestParam(name = "pageUrl") String pageUrl, @RequestParam(name = "fileExt", defaultValue = "") String fileExt) {
        try {
            String fileRelativePath = html2ImageService.excute(pageUrl, fileExt);
            return "redirect:" + fileRelativePath;
        } catch (Exception e) {
            e.printStackTrace();
            return "/error";
        }
    }

    /**
     * html页面PDF
     *
     * @param pageUrl
     * @return
     */
    @RequestMapping("/html2pdf")
    public String html2pdf(@RequestParam(name = "pageUrl") String pageUrl) {
        try {
            String fileRelativePath = html2PdfService.excute(pageUrl);
            return "redirect:" + fileRelativePath;
        } catch (Exception e) {
            e.printStackTrace();
            return "/error";
        }
    }
    /**
     * html页面markdown
     *
     * @param pageUrl
     * @return
     */
    @RequestMapping("/html2markdown")
    public String html2markdown(@RequestParam(name = "pageUrl") String pageUrl) {
        try {
            String fileRelativePath = html2MarkdownService.excute(pageUrl);
            return "redirect:" + fileRelativePath;
        } catch (Exception e) {
            e.printStackTrace();
            return "/error";
        }
    }

    /**
     * html页面转文档
     *
     * @param myAjaxPost
     * @return
     */
    @RequestMapping("/html2file")
    public @ResponseBody
    MyAjaxResult html2file(@RequestBody MyAjaxPost myAjaxPost) {
        MyAjaxResult result = new MyAjaxResult();
        try {
            String fileRelativePath = null;
            if (MyAjaxPost.TO_IMG.equals(myAjaxPost.getFileType())) {
                fileRelativePath = html2ImageService.excute(myAjaxPost.getPageUrl(), myAjaxPost.getFileExt());
            } else if (MyAjaxPost.TO_IMG.equals(myAjaxPost.getFileType())) {
                fileRelativePath = html2PdfService.excute(myAjaxPost.getPageUrl());
            }else if (MyAjaxPost.TO_MD.equals(myAjaxPost.getFileType())) {
                fileRelativePath = html2MarkdownService.excute(myAjaxPost.getPageUrl());
            }else {
                fileRelativePath = "暂时不支持该类型文档转化！";
            }
            result.setResult(fileRelativePath);
        } catch (Exception e) {
            e.printStackTrace();
            result.setErrorMsg("解析失败！");
        }
        return result;
    }
}
