package rpa.common;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author k_go
 * @version 1.0
 * @date 2020/05/14 9:59
 */
public class CommonUtils {
    /**
     * システム日付取得
     * @return
     */
    public static String GetSystemTime(){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(day) + " ||";
    }

}
