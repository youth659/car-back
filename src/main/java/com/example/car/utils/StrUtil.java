package com.example.car.utils;

import java.util.Set;

/**
 * 字符串工具类
 * <br>
 * created date 2021/4/22 22:33
 *
 * @author yh
 */
public class StrUtil {
    public static String cutStr(String key){
        String newStr = "";
        if(key.charAt(1)== '_'){
            newStr = key.substring(2);
        }
        newStr = newStr.toLowerCase();
        newStr = newStr.valueOf(newStr.charAt(0)).toUpperCase() + newStr.substring(1);
        return newStr;
    }


}
