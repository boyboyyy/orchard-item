package com.orchard.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "仓库分页信息")
public class StoagePageQueryDTO implements Serializable {
    @ApiModelProperty("仓库名")
    //仓库姓名
    private String name;

    @ApiModelProperty("页码")
    //页码
    private Integer pageNumber;

    @ApiModelProperty("每页显示记录数")
    //每页显示记录数
    private Integer pageSize;


}
