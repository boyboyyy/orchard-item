package com.orchard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(description = "员工启用或禁用的数据")
public class EmployeeStartOrStopDTO implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("员工启用或禁用数据")
    private Integer isValid;
}
