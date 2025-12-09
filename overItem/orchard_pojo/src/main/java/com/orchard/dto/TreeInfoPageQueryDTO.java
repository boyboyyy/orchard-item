package com.orchard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(description = "树木的分页数据")
public class TreeInfoPageQueryDTO implements Serializable {

    @ApiModelProperty("树木名")
    //仓库姓名
    private String name;
    @ApiModelProperty("页码")
    //页码
    private Integer pageNumber;

    @ApiModelProperty("每页显示记录数")
    //每页显示记录数
    private Integer pageSize;
}
