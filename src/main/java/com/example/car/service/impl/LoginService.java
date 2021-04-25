package com.example.car.service.impl;

import com.example.car.result.Result;
import com.example.car.service.ILoginService;
import com.example.car.vo.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录
 * <br>
 * created date 2021/4/22 20:21
 *
 * @author yh
 */
@Service
public class LoginService extends CommonService implements ILoginService {

    @Override
    public List<Map<String, Object>> Login(String username, String pwd) {
        String where = "";
        where += " s_username='" + username + "' and s_password='" + pwd + "'";
        List<Map<String, Object>> list = queryList("user", where);
        return list;
    }

    /**
     * 更新登陆时间
     *
     * @param id
     * @param time
     * @return
     */
    public Result UpdLoginTime(String id, String time) {
        Map<String, Object> map = new HashMap<>();
        map.put("d_lastLoginDate", time);
        map.put("d_remainDate", time);
        map.put("n_isOnLine", 1);

        Map<String, Object> wheremap = new HashMap<>();
        wheremap.put("s_id", id);

        return UpdateData("t_user", map, wheremap);
    }

//    public Result AddUser() {
//        return Update("user", map, whereMap);
//    }
}
