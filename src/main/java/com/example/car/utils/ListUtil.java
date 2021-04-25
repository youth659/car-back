package com.example.car.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * List工具类
 * <br>
 * created date 2021/4/22 22:29
 *
 * @author yh
 */
public class ListUtil {
    /**
     * 格式化List key
     *
     * @return
     */
    public static List<Map<String, Object>> formatKey(List<Map<String, Object>> list) {
        List<Map<String, Object>> newList = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < list.size(); i++) {
            List<String> setStr = new ArrayList<>(list.get(i).keySet());
            Map<String, Object> map = new HashMap<>();

            for (int j = 0; j < setStr.size(); j++) {
                // key
                StringBuilder sb = new StringBuilder();
                sb.append(StrUtil.cutStr(setStr.get(j)));
                //value
                StringBuilder sb2 = new StringBuilder();
                sb2.append(list.get(i).get(setStr.get(j)));

                map.put(sb.toString(), sb2);
            }
            newList.add(map);
        }
        return newList;
    }
}
