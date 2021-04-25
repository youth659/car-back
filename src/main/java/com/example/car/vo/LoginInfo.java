package com.example.car.vo;

import com.example.car.bo.User;
import lombok.Data;

/**
 * 登录获取信息
 * <br>
 * created date 2021/4/22 20:04
 *
 * @author yh
 */
@Data
public class LoginInfo {
    private User user;
    private String token;
}
