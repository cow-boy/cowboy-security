package com.cowboy.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户查询条件
 *
 * @author huxu
 * @create 2017-12-08 9:58
 **/
@Data
public class UserQueryCondition {

    private String username;

    @ApiModelProperty(value = "用户年龄起始值")
    private int age;

    @ApiModelProperty(value = "用户年龄终止值")
    private int ageTo;

    private String xxx;

}
