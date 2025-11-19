package com.orchard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(description = "货物分页参数")
public class GoodPageQueryDTO implements Serializable {
    @ApiModelProperty("货物名")
    //仓库姓名
    private String name;

    @ApiModelProperty("页码")
    //页码
    private Integer pageNumber;

    @ApiModelProperty("每页显示记录数")
    //每页显示记录数
    private Integer pageSize;

    @ApiModelProperty("仓库的名称")
    //每页显示记录数
    private Integer storage;

    @ApiModelProperty("货物分类名")
    //每页显示记录数
    private Integer goodsType;
}
