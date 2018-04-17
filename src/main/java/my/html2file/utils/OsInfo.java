package my.html2file.utils;

/**
 * 服务器所属的操作系统信息类
 *
 * @author 欧阳洁
 * @create 2017-08-10 16:02
 **/
public class OsInfo {
    private static final String osName = System.getProperty("os.name").toLowerCase();
    
    private static final String version = System.getProperty("os.version");
    
    private static final String arch = System.getProperty("os.arch");

    public static boolean isLinux(){
        return osName.indexOf("linux") >= 0;
    }

    public static boolean isMacosName(){
        return osName.indexOf("mac") >= 0 && osName.indexOf("os")>0 && osName.indexOf("x")<0;
    }

    public static boolean isMacosNameX(){
        return osName.indexOf("mac") >= 0 && osName.indexOf("os")>0 && osName.indexOf("x")>0;
    }

    public static boolean isWindows(){
        return osName.indexOf("windows") >= 0;
    }

    public static boolean isosName2(){
        return osName.indexOf("os/2") >= 0;
    }

    public static boolean isSolaris(){
        return osName.indexOf("solaris") >= 0;
    }

    public static boolean isSunosName(){
        return osName.indexOf("sunos") >= 0;
    }

    public static boolean isMPEiX(){
        return osName.indexOf("mpe/ix") >= 0;
    }

    public static boolean isHPUX(){
        return osName.indexOf("hp-ux") >= 0;
    }

    public static boolean isAix(){
        return osName.indexOf("aix") >= 0;
    }

    public static boolean isosName390(){
        return osName.indexOf("os/390") >= 0;
    }

    public static boolean isFreeBSD(){
        return osName.indexOf("freebsd") >= 0;
    }

    public static boolean isIrix(){
        return osName.indexOf("irix") >= 0;
    }

    public static boolean isDigitalUnix(){
        return osName.indexOf("digital") >= 0 && osName.indexOf("unix")>0;
    }

    public static boolean isNetWare(){
        return osName.indexOf("netware") >= 0;
    }

    public static boolean isosNameF1(){
        return osName.indexOf("osf1") >= 0;
    }

    public static boolean isOpenVMS(){
        return osName.indexOf("openvms") >= 0;
    }

    /**
     * 获取操作系统名字
     * @return 操作系统名
     */
    public static String getOsName(){
        return osName;
    }

    public static String getVersion(){
        return version;
    }

    public static String getArch() {
        return arch;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(OsInfo.getOsName());
    }
}
