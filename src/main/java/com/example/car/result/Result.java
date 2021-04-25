package com.example.car.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回结果
 * <br>
 * created date 2021/4/22 19:33
 *
 * @author yh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("统一格式返回结果")
public class Result {
    @ApiModelProperty("状态码")
    private int code;
    @ApiModelProperty("错误信息")
    private String msg;
    @ApiModelProperty("返回结果")
    private Object data;

    public Result(Object data){
        this.data = data;
    }
}
