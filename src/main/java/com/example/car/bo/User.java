package com.example.car.bo;

import lombok.Data;

import java.util.Date;

/**
 * 用户信息
 * <br>
 * created date 2021/4/22 20:08
 *
 * @author yh
 */
@Data
public class User {
    private String id;
    private String userName;
    private String name;
    private String headPhoto;
    private Date createTime;
    private Integer age;
    private String phoneNum;
    private String email;
    private String idCard;
}
