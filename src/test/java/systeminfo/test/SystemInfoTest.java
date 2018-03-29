package systeminfo.test;

import my.utils.OsInfo;
import org.junit.Test;

public class SystemInfoTest {
    @Test
    public void systemInfo(){
        System.out.println("*****************系统信息****************");
        System.out.println(OsInfo.getOsName());
        System.out.println(OsInfo.getVersion());
        System.out.println(OsInfo.getArch());
        System.out.println("*****************系统信息****************");
    }
}
