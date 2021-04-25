package com.example.car.utils;

import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * <br>
 * created date 2021/4/23 14:47
 *
 * @author yh
 */
public class DateUtil {

    private static String sdfStr = "yyyy-MM-dd HH:mm:ss";

    public static boolean isDateFormat(String string) {
        if (string == null) {
            return false;
        }
        try {
            parseDate(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SneakyThrows
    public static Date parseDate(String parseStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(sdfStr);
        return sdf.parse(parseStr);
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getDateStr(){
        SimpleDateFormat sdf = new SimpleDateFormat(sdfStr);
        return sdf.format(new Date());
    }
}
