package com.orchard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@ApiModel(description = "分页查询的参数")
@Data
public class EmployeePageQueryDTO implements Serializable {
    @ApiModelProperty("员工姓名")
    //员工姓名
    private String name;

    @ApiModelProperty("页码")
    //页码
    private int page;

    @ApiModelProperty("每页显示记录数")
    //每页显示记录数
    private int pageSize;

}
