package com.orchard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(description = "分页查询的参数")
@Data
public class EmployeeDTO implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("员工账号")
    private String no;

    @ApiModelProperty("员工名字")
    private String name;

    @ApiModelProperty("年龄")
    private String age;

    @ApiModelProperty("性别")
    private String sex;


    @ApiModelProperty("电话号码")
    private String phone;

}
