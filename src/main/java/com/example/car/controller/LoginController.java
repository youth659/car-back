package com.example.car.controller;

import com.example.car.result.Result;
import com.example.car.service.ILoginService;
import com.example.car.utils.DateUtil;
import com.example.car.utils.ListUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * 登录
 * <br>
 * created date 2021/4/22 19:26
 *
 * @author yh
 */
@RestController
@RequestMapping(value = "api/v1")
public class LoginController {
    Logger log = Logger.getLogger(LoginController.class.getName());

    @Autowired
    ILoginService loginService;

    @ApiOperation("用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result Login(@ApiParam("用户名") String username, @ApiParam("密码") String pwd) {
        log.info("==== 登录了");
        Result result = null;
        if (StringUtils.hasLength(username) && StringUtils.hasLength(pwd)) {
            List<Map<String, Object>> list = loginService.Login(username, pwd);
            List<Map<String, Object>> list2 = ListUtil.formatKey(list);

            result = new Result(list2);
        } else {
            result = new Result(400, "用户名或密码不能为空", "");
        }
        return result;
    }

    @RequestMapping(value = "/user/adduser", method = RequestMethod.POST)
    public Result AddUser(Map<String, Object> map) {
        return loginService.AddUser(map);
    }

    @GetMapping(value = "/timestamp/getdate")
    public Result GetDate() {
        return new Result(DateUtil.getDateStr());
    }
}
