package com.example.car.service.impl;

import com.example.car.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import javax.swing.text.html.ObjectView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 公共类
 * <br>
 * created date 2021/4/22 21:31
 *
 * @author yh
 */
public class CommonService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> queryList(String table, String where) {
        String sql = "select * from t_" + table;
        if (StringUtils.hasLength(where)) {
            sql += " where " + where;
        }
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    public Result InsertData(String table, Map<String, Object> map) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into t_" + table + "(");

        StringBuilder sbVal = new StringBuilder();

        List<String> keys = new ArrayList<>(map.keySet());

        for (int i = 0; i < keys.size(); i++) {
            sql.append(keys.get(i));

            Object value = map.get(keys.get(i));
            if (value instanceof String || value instanceof Date) {
                sbVal.append("'" + value + "'");
            } else {
                sbVal.append(value);
            }
        }
        sql.append(")").append(" values(").append(sbVal).append(")");
        jdbcTemplate.update(sql.toString());
        return new Result();
    }

    public Result UpdateData(String table, Map<String, Object> map, Map<String, Object> whereMap) {
        StringBuilder sql = new StringBuilder();
        sql.append("update " + table + " set ");

        List<String> mapKey = new ArrayList<>(map.keySet());
        for (int i = 0; i < mapKey.size(); i++) {
            sql.append(mapKey.get(i) + "='" + map.get(mapKey.get(i)) + "'");
        }

        List<String> whereMapKey = new ArrayList<>(whereMap.keySet());
        StringBuilder whereSql = new StringBuilder();
        for (int i = 0; i < whereMapKey.size(); i++) {
            if (i == 0) {
                whereSql.append(" where " + whereMapKey.get(i) + "='" + whereMap.get(whereMap.get(i)) + "' ");
            } else {
                whereSql.append(" and " + whereMapKey.get(i) + "='" + whereMap.get(whereMap.get(i)) + "' ");
            }
        }
        sql.append(whereSql);
        jdbcTemplate.update(sql.toString());
        return new Result();
    }
}
