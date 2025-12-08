package com.orchard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(description = "货物新增参数")
public class GoodDTO implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("记录")
    private String remark;

    @ApiModelProperty("货物名字")
    private String name;
    @ApiModelProperty("仓库名字")
    private Integer storage;
    @ApiModelProperty("货物分类")
    private Integer goodsType;
    @ApiModelProperty("货物数量")
    private Integer count;

}
