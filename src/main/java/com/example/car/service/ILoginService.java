package com.example.car.service;

import com.example.car.result.Result;
import com.example.car.vo.LoginInfo;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 登录
 * <br>
 * created date 2021/4/22 20:21
 *
 * @author yh
 */
public interface ILoginService {
    public abstract List<Map<String, Object>> Login(String username, String pwd);

    public abstract Result AddUser(Map<String, Object> map);
}
