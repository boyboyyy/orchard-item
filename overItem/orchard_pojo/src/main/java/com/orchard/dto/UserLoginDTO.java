package com.orchard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(description = "员工登录时传递的数据模型")
public class UserLoginDTO implements Serializable {
    @ApiModelProperty("账号")
    private String no;
    @ApiModelProperty("密码")
    private String password;
}
