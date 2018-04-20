package my.html2file.utils;

/**
 * 路径获取工具
 *
 * @author 欧阳洁
 * @since 2018-03-28 14:11
 */
public class PathUtils {
    /**
     * 获取class目录下单文件绝对路径
     *
     * @param path
     * @return
     */
    public static String getClassRootPath(String path) {
        path = PathUtils.trimToEmpty(path);
        String filePath = PathUtils.class.getResource("/").getPath().toString();
        if (filePath == null) return null;
        String p = "";
        if (path.startsWith("/")) {
            p = filePath + path.substring(1);
        } else {
            p = filePath + path;
        }
        return p;
    }

    /**
     * 获取参照class路径，获取原生路径
     * @param path
     * @return
     */
    public static String getPathBaseClass(String path){
        path = PathUtils.trimToEmpty(path);
        String filePath = PathUtils.class.getResource(path).getPath().toString();
        if(OsInfo.isWindows()){
            return getWindowsRightPath(filePath);
        }
        return filePath;
    }

    /**
     * 获取window下的正确路径
     * @param path
     * @return
     */
    public static String getWindowsRightPath(String path){
        path = path.replace("/","\\");
        if(path.startsWith("\\")){ path = path.substring(1);}
        while (path.indexOf("\\\\") >= 0){ path = path.replace("\\\\","\\");}
        return path;
    }

    /**
     * 去除字符串两边空格，为空就转成空字符串
     *
     * @param str
     * @return
     */
    public static String trimToEmpty(final String str) {
        return str == null ? "" : str.trim();
    }
}
