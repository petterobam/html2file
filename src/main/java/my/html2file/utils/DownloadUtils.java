package my.html2file.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 文件下载相关工具类
 *
 * @author 欧阳洁
 * @create 2017-08-14 11:53
 **/
public class DownloadUtils {
    protected static final Logger logger = LoggerFactory.getLogger(DownloadUtils.class);

    /**
     * 从网络Url中下载文件
     *
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void downLoadFromUrl(String urlStr, String fileName, String savePath) {
        downLoadFromUrl(urlStr, fileName, savePath, 3000);
    }

    /**
     * 从网络Url中下载文件
     *
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void downLoadFromUrl(String urlStr, String fileName, String savePath, int timeout) {
        //得到输入流
        InputStream inputStream = getInputStreamFromUrl(urlStr, timeout);
        //获取自己数组
        byte[] getData = new byte[0];
        try {
            getData = readInputStream(inputStream);
        } catch (IOException e) {
            logger.error("读取异常！", e);
            e.printStackTrace();
        }

        //文件保存位置
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            while (!saveDir.mkdir() && !saveDir.mkdirs()) ;
        }
        File file = new File(saveDir + File.separator + fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(getData);
        } catch (Exception e) {
            logger.error("文件不存在！", e);
        } finally {
            FilesUtils.closeQuietly(fos);
            FilesUtils.closeQuietly(inputStream);
        }
        logger.info("[" + urlStr + "] 下载成功！");
    }

    /**
     * 从网络Url中下载文件
     *
     * @param urlStr
     * @throws IOException
     */
    public static String getContentFromUrl(String urlStr) {
        return getContentFromUrl(urlStr, 3000);
    }

    /**
     * 从网络Url中下载文件
     *
     * @param urlStr
     * @throws IOException
     */
    public static String getContentFromUrl(String urlStr, int timeout) {
        //得到输入流
        InputStream inputStream = getInputStreamFromUrl(urlStr, timeout);
        //获取自己数组
        byte[] bytes = new byte[0];
        try {
            bytes = readInputStream(inputStream);
        } catch (IOException e) {
            logger.error("读取异常！", e);
            e.printStackTrace();
        }
        if (bytes == null) {
            return "";
        }
        //String data = Base64.getEncoder().encodeToString(getData);
        String data = null;
        try {
            data = new String(bytes, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        logger.info("[" + urlStr + "] 读取成功！");
        return data;
    }

    /**
     * 传根据文件地址获取文件流
     *
     * @param urlStr
     * @return
     */
    public static InputStream getInputStreaFromUrl(String urlStr) {
        return getInputStreamFromUrl(urlStr, 3000);
    }

    /**
     * 传根据文件地址获取文件流
     *
     * @param urlStr
     * @return
     */
    public static InputStream getInputStreamFromUrl(String urlStr, int timeout) {
        logger.info("下载文件：{}", urlStr);
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            logger.error("地址无效！", e);
            e.printStackTrace();
            return null;
        }
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            logger.error("连接异常！", e);
            e.printStackTrace();
            return null;
        }
        //设置超时间为3秒
        conn.setConnectTimeout(timeout);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = null;
        try {
            inputStream = conn.getInputStream();
        } catch (IOException e) {
            logger.error("网络异常！", e);
            e.printStackTrace();
        }
        return inputStream;
    }

    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
