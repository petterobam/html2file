package my.html2file.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * 基础Utils
 *
 * @author 欧阳洁
 * @since 2018-03-28 14:40
 */
public class BaseUtils {
    /**
     * 字符串是否为空
     * @param str
     * @return
     */
    public static boolean isBlank(String str){
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
    /**
     * 字符串是否为空
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }

    public static boolean isNumeric(String cs) {
        if(isBlank(cs)) {
            return false;
        } else {
            int sz = cs.length();

            for(int i = 0; i < sz; ++i) {
                if(!Character.isDigit(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }
    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间有-分割.
     *
     * @return f3fe3397-3eeb-4937-9dd0-7adec82c4c77  36位长
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     *
     * @return uuid2:7d4901f285814e04bb814b0f337eb173  32
     */
    public static String uuid2() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
     *
     * @param sformat yyyyMMddHHmmss
     * @return
     */
    public static String getDateStr(String sformat) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(sformat);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    /**
     * 是否包含
     * @param array
     * @param objectToFind
     * @return
     */
    public static boolean contains(Object[] array, Object objectToFind) {
        if (null != array) {
            for (Object o : array) {
                if (Objects.equals(o, objectToFind)) {
                    return true;
                }
            }
        }
        return false;
    }
}
