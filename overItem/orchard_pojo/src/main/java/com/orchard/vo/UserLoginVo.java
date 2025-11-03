package com.orchard.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "员工登录返回的数据格式")
public class UserLoginVo implements Serializable {
    @ApiModelProperty("用户名")
    private  String username;
    @ApiModelProperty("主键名")
    private  Long id;
    @ApiModelProperty("姓名")
    private  String name;
    @ApiModelProperty("jwt令牌")
    private  String token;
    @ApiModelProperty("账号")
    private  String no;
    @ApiModelProperty("电话号码")
    private  String phone;
}
